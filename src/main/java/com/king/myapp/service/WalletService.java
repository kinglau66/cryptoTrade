package com.king.myapp.service;

import com.king.myapp.domain.Wallet;
import com.king.myapp.repository.CoinPriceRepository;
import com.king.myapp.repository.WalletRepository;
import com.king.myapp.service.mapper.CoinPriceMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final CoinPriceRepository coinPriceRepository;
    private final WalletRepository walletRepository;
    private final CoinPriceMapper coinPriceMapper;
    Log log = LogFactory.getLog(WalletService.class);

    @Autowired
    public WalletService(CoinPriceRepository coinPriceRepository, WalletRepository walletRepository, CoinPriceMapper coinPriceMapper) {
        this.coinPriceRepository = coinPriceRepository;
        this.walletRepository = walletRepository;
        this.coinPriceMapper = coinPriceMapper;
    }

    public Wallet getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId).orElse(null);
    }
}
