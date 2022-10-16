package com.king.myapp.service.dto;

import com.king.myapp.domain.WalletCoinBalanceDto;
import com.king.myapp.domain.WalletTransactionDto;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.king.myapp.domain.Wallet} entity
 */
public class WalletDto implements Serializable {

    private final Long id;
    private final Long userId;
    private final Set<WalletCoinBalanceDto> balances;
    private final Set<WalletTransactionDto> transactions;

    public WalletDto(Long id, Long userId, Set<WalletCoinBalanceDto> balances, Set<WalletTransactionDto> transactions) {
        this.id = id;
        this.userId = userId;
        this.balances = balances;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Set<WalletCoinBalanceDto> getBalances() {
        return balances;
    }

    public Set<WalletTransactionDto> getTransactions() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletDto entity = (WalletDto) o;
        return (
            Objects.equals(this.id, entity.id) &&
            Objects.equals(this.userId, entity.userId) &&
            Objects.equals(this.balances, entity.balances) &&
            Objects.equals(this.transactions, entity.transactions)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, balances, transactions);
    }

    @Override
    public String toString() {
        return (
            getClass().getSimpleName() +
            "(" +
            "id = " +
            id +
            ", " +
            "userId = " +
            userId +
            ", " +
            "balances = " +
            balances +
            ", " +
            "transactions = " +
            transactions +
            ")"
        );
    }
}
