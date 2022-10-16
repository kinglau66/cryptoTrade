package com.king.myapp.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

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
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<WalletCoinBalance> balances = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<WalletTransaction> transactions = new HashSet<>();

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
