package com.king.myapp.web.rest;

import com.king.myapp.domain.User;
import com.king.myapp.repository.UserRepository;
import com.king.myapp.security.SecurityUtils;
import com.king.myapp.service.CoinPriceService;
import com.king.myapp.service.MailService;
import com.king.myapp.service.UserService;
import com.king.myapp.service.dto.AdminUserDTO;
import com.king.myapp.service.dto.CoinBestPriceDTO;
import com.king.myapp.service.dto.PasswordChangeDTO;
import com.king.myapp.web.rest.errors.EmailAlreadyUsedException;
import com.king.myapp.web.rest.errors.InvalidPasswordException;
import com.king.myapp.web.rest.errors.LoginAlreadyUsedException;
import com.king.myapp.web.rest.vm.KeyAndPasswordVM;
import com.king.myapp.web.rest.vm.ManagedUserVM;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api/coin")
public class CoinResource {

    private static class AccountResourceException extends RuntimeException {

        private AccountResourceException(String message) {
            super(message);
        }
    }

    private final Logger log = LoggerFactory.getLogger(CoinResource.class);

    private final UserRepository userRepository;
    private final CoinPriceService coinPriceService;

    public CoinResource(UserRepository userRepository, CoinPriceService coinPriceService) {
        this.userRepository = userRepository;
        this.coinPriceService = coinPriceService;
    }

    @GetMapping("/ticker")
    public List<CoinBestPriceDTO> getBestPrice() {
        return this.coinPriceService.getBestPrice();
    }
}
