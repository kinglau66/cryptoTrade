package com.king.myapp.web.rest;

import com.king.myapp.repository.UserRepository;
import com.king.myapp.service.CoinPriceService;
import com.king.myapp.service.WalletService;
import com.king.myapp.service.dto.TransactionReqDTO;
import com.king.myapp.service.dto.WalletDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api/wallet")
public class WalletResource {

    private static class AccountResourceException extends RuntimeException {

        private AccountResourceException(String message) {
            super(message);
        }
    }

    private final Logger log = LoggerFactory.getLogger(WalletResource.class);

    private final UserRepository userRepository;
    private final CoinPriceService coinPriceService;
    private final WalletService walletService;

    public WalletResource(UserRepository userRepository, CoinPriceService coinPriceService, WalletService walletService) {
        this.userRepository = userRepository;
        this.coinPriceService = coinPriceService;
        this.walletService = walletService;
    }

    @GetMapping("/user/{userId}")
    @Transactional
    public WalletDto getWalletByUserId(@PathVariable("userId") Long userId) {
        return this.walletService.getWalletByUserId(userId);
    }

    @PostMapping("/trade-req/{userId}")
    @Transactional
    public boolean trade(@PathVariable("userId") Long userId, @RequestBody TransactionReqDTO transactionReqDTO) {
        return this.walletService.trade(userId, transactionReqDTO);
    }
}
