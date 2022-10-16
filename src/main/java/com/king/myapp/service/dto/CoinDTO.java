package com.king.myapp.service.dto;

import java.util.Objects;
import javax.persistence.Column;
import org.springframework.data.annotation.Id;

/**
 * A DTO representing a user, with only the public attributes.
 */
public class CoinDTO {

    private static final long serialVersionUID = 1L;

    private String code;

    private String symbol;

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
        CoinDTO coinDTO = (CoinDTO) o;
        return isDigital == coinDTO.isDigital && Objects.equals(code, coinDTO.code) && Objects.equals(symbol, coinDTO.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, symbol, isDigital);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoinDTO{");
        sb.append("code='").append(code).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", isDigital=").append(isDigital);
        sb.append('}');
        return sb.toString();
    }
}
