package com.king.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * user's wallet.
 */
@Entity
@Table(name = "wallet_coin_balance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WalletCoinBalance implements Serializable {

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

    @Column(name = "coin_code", updatable = false, nullable = false)
    private String coinCode;

    @JoinColumn(name = "coin_code", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    @JsonIgnore
    private Coin coin;

    @Column(name = "balance", nullable = false, precision = 20, scale = 8)
    private BigDecimal balance;

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

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletCoinBalance that = (WalletCoinBalance) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(walletId, that.walletId) &&
            Objects.equals(coinCode, that.coinCode) &&
            Objects.equals(balance, that.balance)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, walletId, coinCode, balance);
    }

    public static final class WalletCoinBalanceBuilder {

        private Long id;
        private Wallet wallet;
        private Long walletId;
        private String coinCode;
        private Coin coin;
        private BigDecimal balance;

        private WalletCoinBalanceBuilder() {}

        public static WalletCoinBalanceBuilder aWalletCoinBalance() {
            return new WalletCoinBalanceBuilder();
        }

        public WalletCoinBalanceBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public WalletCoinBalanceBuilder withWallet(Wallet wallet) {
            this.wallet = wallet;
            return this;
        }

        public WalletCoinBalanceBuilder withWalletId(Long walletId) {
            this.walletId = walletId;
            return this;
        }

        public WalletCoinBalanceBuilder withCoinCode(String coinCode) {
            this.coinCode = coinCode;
            return this;
        }

        public WalletCoinBalanceBuilder withCoin(Coin coin) {
            this.coin = coin;
            return this;
        }

        public WalletCoinBalanceBuilder withBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public WalletCoinBalance build() {
            WalletCoinBalance walletCoinBalance = new WalletCoinBalance();
            walletCoinBalance.setId(id);
            walletCoinBalance.setWallet(wallet);
            walletCoinBalance.setWalletId(walletId);
            walletCoinBalance.setCoinCode(coinCode);
            walletCoinBalance.setCoin(coin);
            walletCoinBalance.setBalance(balance);
            return walletCoinBalance;
        }
    }
}
