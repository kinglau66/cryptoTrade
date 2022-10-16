package com.king.myapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link WalletTransaction} entity
 */
public class WalletTransactionDto implements Serializable {

    private final Long id;
    private final Long walletId;
    private final String transactionSymbol;
    private final BigDecimal toBalanceBefore;
    private final BigDecimal toBalanceAfter;
    private final BigDecimal frBalanceBefore;
    private final BigDecimal frBalanceAfter;
    private final Instant timestamp;

    public WalletTransactionDto(
        Long id,
        Long walletId,
        String transactionSymbol,
        BigDecimal toBalanceBefore,
        BigDecimal toBalanceAfter,
        BigDecimal frBalanceBefore,
        BigDecimal frBalanceAfter,
        Instant timestamp
    ) {
        this.id = id;
        this.walletId = walletId;
        this.transactionSymbol = transactionSymbol;
        this.toBalanceBefore = toBalanceBefore;
        this.toBalanceAfter = toBalanceAfter;
        this.frBalanceBefore = frBalanceBefore;
        this.frBalanceAfter = frBalanceAfter;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public Long getWalletId() {
        return walletId;
    }

    public String getTransactionSymbol() {
        return transactionSymbol;
    }

    public BigDecimal getToBalanceBefore() {
        return toBalanceBefore;
    }

    public BigDecimal getToBalanceAfter() {
        return toBalanceAfter;
    }

    public BigDecimal getFrBalanceBefore() {
        return frBalanceBefore;
    }

    public BigDecimal getFrBalanceAfter() {
        return frBalanceAfter;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletTransactionDto entity = (WalletTransactionDto) o;
        return (
            Objects.equals(this.id, entity.id) &&
            Objects.equals(this.walletId, entity.walletId) &&
            Objects.equals(this.transactionSymbol, entity.transactionSymbol) &&
            Objects.equals(this.toBalanceBefore, entity.toBalanceBefore) &&
            Objects.equals(this.toBalanceAfter, entity.toBalanceAfter) &&
            Objects.equals(this.frBalanceBefore, entity.frBalanceBefore) &&
            Objects.equals(this.frBalanceAfter, entity.frBalanceAfter) &&
            Objects.equals(this.timestamp, entity.timestamp)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, walletId, transactionSymbol, toBalanceBefore, toBalanceAfter, frBalanceBefore, frBalanceAfter, timestamp);
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
            "transactionSymbol = " +
            transactionSymbol +
            ", " +
            "toBalanceBefore = " +
            toBalanceBefore +
            ", " +
            "toBalanceAfter = " +
            toBalanceAfter +
            ", " +
            "frBalanceBefore = " +
            frBalanceBefore +
            ", " +
            "frBalanceAfter = " +
            frBalanceAfter +
            ", " +
            "timestamp = " +
            timestamp +
            ")"
        );
    }
}
