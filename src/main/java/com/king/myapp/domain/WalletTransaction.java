package com.king.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
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

    @JoinColumn(name = "wallet_id", updatable = false, nullable = false)
    @ManyToOne
    @JsonIgnore
    private Wallet wallet;

    @Column(name = "wallet_id", insertable = false, updatable = false, nullable = false)
    private Long walletId;

    @Column(name = "transaction_symbol", updatable = false, nullable = false)
    private String transactionSymbol;

    @Column(name = "to_balance_before", updatable = false, nullable = false)
    private BigDecimal toBalanceBefore;

    @Column(name = "to_balance_after", updatable = false, nullable = false)
    private BigDecimal toBalanceAfter;

    @Column(name = "fr_balance_before", updatable = false, nullable = false)
    private BigDecimal frBalanceBefore;

    @Column(name = "fr_balance_after", updatable = false, nullable = false)
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
}
