package com.king.myapp.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * user's wallet.
 */
@Entity
@Table(name = "wallet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false, nullable = false)
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<WalletCoinBalance> balances;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<WalletTransaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<WalletCoinBalance> getBalances() {
        return balances;
    }

    public void setBalances(Set<WalletCoinBalance> balances) {
        this.balances = balances;
    }

    public Set<WalletTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<WalletTransaction> transactions) {
        this.transactions = transactions;
    }
}
