package com.king.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * user's wallet.
 */
@Entity
@Table(name = "wallet_transaction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WalletTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @JoinColumn(name = "wallet_id", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    @JsonIgnore
    private Wallet wallet;

    @Column(name = "wallet_id", updatable = false, nullable = false)
    private Long walletId;

    @Column(name = "transaction_symbol", updatable = false, nullable = false)
    private String transactionSymbol;

    @Column(name = "to_balance_before", updatable = false, nullable = false, precision = 20, scale = 8)
    private BigDecimal toBalanceBefore;

    @Column(name = "to_balance_after", updatable = false, nullable = false, precision = 20, scale = 8)
    private BigDecimal toBalanceAfter;

    @Column(name = "fr_balance_before", updatable = false, nullable = false, precision = 20, scale = 8)
    private BigDecimal frBalanceBefore;

    @Column(name = "fr_balance_after", updatable = false, nullable = false, precision = 20, scale = 8)
    private BigDecimal frBalanceAfter;

    @Column(name = "timestamp", updatable = false, nullable = false)
    private Instant timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public String getTransactionSymbol() {
        return transactionSymbol;
    }

    public void setTransactionSymbol(String transactionSymbol) {
        this.transactionSymbol = transactionSymbol;
    }

    public BigDecimal getToBalanceBefore() {
        return toBalanceBefore;
    }

    public void setToBalanceBefore(BigDecimal toBalanceBefore) {
        this.toBalanceBefore = toBalanceBefore;
    }

    public BigDecimal getToBalanceAfter() {
        return toBalanceAfter;
    }

    public void setToBalanceAfter(BigDecimal toBalanceAfter) {
        this.toBalanceAfter = toBalanceAfter;
    }

    public BigDecimal getFrBalanceBefore() {
        return frBalanceBefore;
    }

    public void setFrBalanceBefore(BigDecimal frBalanceBefore) {
        this.frBalanceBefore = frBalanceBefore;
    }

    public BigDecimal getFrBalanceAfter() {
        return frBalanceAfter;
    }

    public void setFrBalanceAfter(BigDecimal frBalanceAfter) {
        this.frBalanceAfter = frBalanceAfter;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletTransaction that = (WalletTransaction) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(wallet, that.wallet) &&
            Objects.equals(walletId, that.walletId) &&
            Objects.equals(transactionSymbol, that.transactionSymbol) &&
            Objects.equals(toBalanceBefore, that.toBalanceBefore) &&
            Objects.equals(toBalanceAfter, that.toBalanceAfter) &&
            Objects.equals(frBalanceBefore, that.frBalanceBefore) &&
            Objects.equals(frBalanceAfter, that.frBalanceAfter) &&
            Objects.equals(timestamp, that.timestamp)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            wallet,
            walletId,
            transactionSymbol,
            toBalanceBefore,
            toBalanceAfter,
            frBalanceBefore,
            frBalanceAfter,
            timestamp
        );
    }

    public static final class WalletTransactionBuilder {

        private Long id;
        private Wallet wallet;
        private Long walletId;
        private String transactionSymbol;
        private BigDecimal toBalanceBefore;
        private BigDecimal toBalanceAfter;
        private BigDecimal frBalanceBefore;
        private BigDecimal frBalanceAfter;
        private Instant timestamp;

        private WalletTransactionBuilder() {}

        public static WalletTransactionBuilder aWalletTransaction() {
            return new WalletTransactionBuilder();
        }

        public WalletTransactionBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public WalletTransactionBuilder withWallet(Wallet wallet) {
            this.wallet = wallet;
            return this;
        }

        public WalletTransactionBuilder withWalletId(Long walletId) {
            this.walletId = walletId;
            return this;
        }

        public WalletTransactionBuilder withTransactionSymbol(String transactionSymbol) {
            this.transactionSymbol = transactionSymbol;
            return this;
        }

        public WalletTransactionBuilder withToBalanceBefore(BigDecimal toBalanceBefore) {
            this.toBalanceBefore = toBalanceBefore;
            return this;
        }

        public WalletTransactionBuilder withToBalanceAfter(BigDecimal toBalanceAfter) {
            this.toBalanceAfter = toBalanceAfter;
            return this;
        }

        public WalletTransactionBuilder withFrBalanceBefore(BigDecimal frBalanceBefore) {
            this.frBalanceBefore = frBalanceBefore;
            return this;
        }

        public WalletTransactionBuilder withFrBalanceAfter(BigDecimal frBalanceAfter) {
            this.frBalanceAfter = frBalanceAfter;
            return this;
        }

        public WalletTransactionBuilder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public WalletTransaction build() {
            WalletTransaction walletTransaction = new WalletTransaction();
            walletTransaction.setId(id);
            walletTransaction.setWallet(wallet);
            walletTransaction.setWalletId(walletId);
            walletTransaction.setTransactionSymbol(transactionSymbol);
            walletTransaction.setToBalanceBefore(toBalanceBefore);
            walletTransaction.setToBalanceAfter(toBalanceAfter);
            walletTransaction.setFrBalanceBefore(frBalanceBefore);
            walletTransaction.setFrBalanceAfter(frBalanceAfter);
            walletTransaction.setTimestamp(timestamp);
            return walletTransaction;
        }
    }
}
