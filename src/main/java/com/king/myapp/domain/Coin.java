package com.king.myapp.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * type of currency
 */
@Entity
@Table(name = "coin")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Coin {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code", updatable = false, nullable = false, unique = true)
    private String code;

    @Column(name = "symbol", updatable = false, nullable = false, unique = true)
    private String symbol;

    @Column(name = "is_digital", updatable = false, nullable = false, unique = true)
    private boolean isDigital = true;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return isDigital == coin.isDigital && Objects.equals(code, coin.code) && Objects.equals(symbol, coin.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, symbol, isDigital);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coin{");
        sb.append(", code='").append(code).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", isDigital=").append(isDigital);
        sb.append('}');
        return sb.toString();
    }
}
