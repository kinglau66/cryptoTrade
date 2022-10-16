package com.king.myapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link WalletCoinBalance} entity
 */
public class WalletCoinBalanceDto implements Serializable {

    private final Long id;
    private final Long walletId;
    private final String coinCode;
    private final BigDecimal balance;

    public WalletCoinBalanceDto(Long id, Long walletId, String coinCode, BigDecimal balance) {
        this.id = id;
        this.walletId = walletId;
        this.coinCode = coinCode;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getWalletId() {
        return walletId;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletCoinBalanceDto entity = (WalletCoinBalanceDto) o;
        return (
            Objects.equals(this.id, entity.id) &&
            Objects.equals(this.walletId, entity.walletId) &&
            Objects.equals(this.coinCode, entity.coinCode) &&
            Objects.equals(this.balance, entity.balance)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, walletId, coinCode, balance);
    }

    @Override
    public String toString() {
        return (
            getClass().getSimpleName() +
            "(" +
            "id = " +
            id +
            ", " +
            "walletId = " +
            walletId +
            ", " +
            "coinCode = " +
            coinCode +
            ", " +
            "balance = " +
            balance +
            ")"
        );
    }
}
