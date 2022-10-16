package com.king.myapp.service.mapper;

import com.king.myapp.domain.Wallet;
import com.king.myapp.service.dto.WalletDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalletMapper {
    Wallet walletDtoToWallet(WalletDto walletDto);

    WalletDto walletToWalletDto(Wallet wallet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Wallet updateWalletFromWalletDto(WalletDto walletDto, @MappingTarget Wallet wallet);

    @AfterMapping
    default void linkBalances(@MappingTarget Wallet wallet) {
        wallet.getBalances().forEach(balance -> balance.setWallet(wallet));
    }

    @AfterMapping
    default void linkTransactions(@MappingTarget Wallet wallet) {
        wallet.getTransactions().forEach(transaction -> transaction.setWallet(wallet));
    }
}
