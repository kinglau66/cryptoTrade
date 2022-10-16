package com.king.myapp.service;

import com.king.myapp.domain.CoinPrice;
import com.king.myapp.domain.Wallet;
import com.king.myapp.domain.WalletCoinBalance;
import com.king.myapp.domain.WalletTransaction;
import com.king.myapp.repository.CoinPriceRepository;
import com.king.myapp.repository.WalletRepository;
import com.king.myapp.service.dto.TransactionReqDTO;
import com.king.myapp.service.dto.WalletDto;
import com.king.myapp.service.mapper.WalletMapper;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {

    private final CoinPriceRepository coinPriceRepository;
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    Log log = LogFactory.getLog(WalletService.class);

    @Autowired
    public WalletService(CoinPriceRepository coinPriceRepository, WalletRepository walletRepository, WalletMapper walletMapper) {
        this.coinPriceRepository = coinPriceRepository;
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    public WalletDto getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId).map(this.walletMapper::walletToWalletDto).orElse(null);
    }

    @Transactional
    public boolean trade(Long userId, TransactionReqDTO transactionReqDTO) {
        CoinPrice price =
            this.coinPriceRepository.findBestPriceBySymbol(transactionReqDTO.getSymbol())
                .orElseThrow(() -> new RuntimeException("invalidTransaction"));
        if (transactionReqDTO.getSellAmount() == null && transactionReqDTO.getBuyAmount() == null) {
            throw new RuntimeException("invalidTradeAmount");
        }
        if (transactionReqDTO.getSellAmount() != null && transactionReqDTO.getBuyAmount() != null) {
            throw new RuntimeException("invalidTradeRequest");
        }
        Wallet wallet = walletRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("walletNotExist"));
        Map<String, WalletCoinBalance> balance = wallet
            .getBalances()
            .stream()
            .collect(Collectors.toMap(item -> item.getCoinCode(), item -> item));

        if (transactionReqDTO.getBuyAmount() != null) {
            WalletCoinBalance fromCoin = Optional
                .ofNullable(balance.getOrDefault(price.getFrCoinCode(), null))
                .orElse(
                    WalletCoinBalance.WalletCoinBalanceBuilder
                        .aWalletCoinBalance()
                        .withWalletId(wallet.getId())
                        .withBalance(BigDecimal.ZERO)
                        .withCoinCode(price.getFrCoinCode())
                        .build()
                );

            WalletCoinBalance toCoin = Optional
                .ofNullable(balance.getOrDefault(price.getToCoinCode(), null))
                .orElse(
                    WalletCoinBalance.WalletCoinBalanceBuilder
                        .aWalletCoinBalance()
                        .withWalletId(wallet.getId())
                        .withBalance(BigDecimal.ZERO)
                        .withCoinCode(price.getToCoinCode())
                        .build()
                );
            BigDecimal frBalanceBefore = fromCoin.getBalance();
            BigDecimal frBalanceAfter = fromCoin.getBalance().add(transactionReqDTO.getBuyAmount());
            fromCoin.setBalance(frBalanceAfter);
            BigDecimal toBalanceBefore = toCoin.getBalance();
            BigDecimal toBalanceAfter = toCoin.getBalance().subtract(transactionReqDTO.getBuyAmount().multiply(price.getBestAskprice()));
            if (toBalanceAfter.compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("invalidBalance");
            }
            toCoin.setBalance(toBalanceAfter);
            balance.put(price.getFrCoinCode(), fromCoin);
            balance.put(price.getToCoinCode(), toCoin);
            wallet.setBalances(new HashSet<>(balance.values()));
            WalletTransaction transaction = WalletTransaction.WalletTransactionBuilder
                .aWalletTransaction()
                .withTimestamp(Instant.now())
                .withFrBalanceBefore(frBalanceBefore)
                .withFrBalanceAfter(frBalanceAfter)
                .withToBalanceBefore(toBalanceBefore)
                .withToBalanceAfter(toBalanceAfter)
                .withTransactionSymbol(transactionReqDTO.getSymbol())
                .withWalletId(wallet.getId())
                .build();
            wallet.getTransactions().add(transaction);
            walletRepository.save(wallet);
            return true;
        } else if (transactionReqDTO.getSellAmount() != null) {
            WalletCoinBalance fromCoin = Optional
                .ofNullable(balance.getOrDefault(price.getFrCoinCode(), null))
                .orElse(
                    WalletCoinBalance.WalletCoinBalanceBuilder
                        .aWalletCoinBalance()
                        .withWalletId(wallet.getId())
                        .withBalance(BigDecimal.ZERO)
                        .withCoinCode(price.getFrCoinCode())
                        .build()
                );

            WalletCoinBalance toCoin = Optional
                .ofNullable(balance.getOrDefault(price.getToCoinCode(), null))
                .orElse(
                    WalletCoinBalance.WalletCoinBalanceBuilder
                        .aWalletCoinBalance()
                        .withWalletId(wallet.getId())
                        .withBalance(BigDecimal.ZERO)
                        .withCoinCode(price.getToCoinCode())
                        .build()
                );
            BigDecimal frBalanceBefore = fromCoin.getBalance();
            BigDecimal frBalanceAfter = fromCoin.getBalance().subtract(transactionReqDTO.getSellAmount());
            if (frBalanceAfter.compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("invalidBalance");
            }
            fromCoin.setBalance(frBalanceAfter);
            BigDecimal toBalanceBefore = toCoin.getBalance();
            BigDecimal toBalanceAfter = toCoin.getBalance().add(transactionReqDTO.getSellAmount().multiply(price.getBestBidprice()));
            toCoin.setBalance(toBalanceAfter);
            balance.put(price.getFrCoinCode(), fromCoin);
            balance.put(price.getToCoinCode(), toCoin);
            wallet.setBalances(new HashSet<>(balance.values()));
            WalletTransaction transaction = WalletTransaction.WalletTransactionBuilder
                .aWalletTransaction()
                .withTimestamp(Instant.now())
                .withFrBalanceBefore(frBalanceBefore)
                .withFrBalanceAfter(frBalanceAfter)
                .withToBalanceBefore(toBalanceBefore)
                .withToBalanceAfter(toBalanceAfter)
                .withTransactionSymbol(transactionReqDTO.getSymbol())
                .withWalletId(wallet.getId())
                .build();
            wallet.getTransactions().add(transaction);
            walletRepository.save(wallet);
            return true;
        }
        return false;
    }
}
