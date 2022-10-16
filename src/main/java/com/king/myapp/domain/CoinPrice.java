package com.king.myapp.domain;

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
@Table(name = "coin_price")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CoinPrice {

    private static final long serialVersionUID = 1L;

    // TODO change to symbol instant key
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "symbol", updatable = false, nullable = false)
    private String symbol;

    @JoinColumn(name = "fr_coin_id", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private Coin frCoin;

    @Column(name = "fr_coin_id", updatable = false, nullable = false)
    private String frCoinCode;

    @JoinColumn(name = "to_coin_id", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private Coin toCoin;

    @Column(name = "to_coin_id", updatable = false, nullable = false)
    private String toCoinCode;

    @Column(name = "best_ask_price", updatable = false, nullable = false)
    private BigDecimal bestAskprice;

    @Column(name = "best_bid_price", updatable = false, nullable = false)
    private BigDecimal bestBidprice;

    @Column(name = "binance_ask_price", updatable = false, nullable = false)
    private BigDecimal binanceAskPrice;

    @Column(name = "binance_bid_price", updatable = false, nullable = false)
    private BigDecimal binanceBidPrice;

    @Column(name = "huuobi_ask_price", updatable = false, nullable = false)
    private BigDecimal huobiAskPrice;

    @Column(name = "huobi_bid_price", updatable = false, nullable = false)
    private BigDecimal huobiBidPrice;

    @Column(name = "query_time", updatable = false, nullable = false)
    private Instant queryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Coin getFrCoin() {
        return frCoin;
    }

    public void setFrCoin(Coin frCoin) {
        this.frCoin = frCoin;
    }

    public Coin getToCoin() {
        return toCoin;
    }

    public void setToCoin(Coin toCoin) {
        this.toCoin = toCoin;
    }

    public BigDecimal getBestAskprice() {
        return bestAskprice;
    }

    public void setBestAskprice(BigDecimal bestAskprice) {
        this.bestAskprice = bestAskprice;
    }

    public BigDecimal getBestBidprice() {
        return bestBidprice;
    }

    public void setBestBidprice(BigDecimal bestBidprice) {
        this.bestBidprice = bestBidprice;
    }

    public BigDecimal getBinanceAskPrice() {
        return binanceAskPrice;
    }

    public void setBinanceAskPrice(BigDecimal binanceAskPrice) {
        this.binanceAskPrice = binanceAskPrice;
    }

    public BigDecimal getBinanceBidPrice() {
        return binanceBidPrice;
    }

    public void setBinanceBidPrice(BigDecimal binanceBidPrice) {
        this.binanceBidPrice = binanceBidPrice;
    }

    public BigDecimal getHuobiAskPrice() {
        return huobiAskPrice;
    }

    public void setHuobiAskPrice(BigDecimal huobiAskPrice) {
        this.huobiAskPrice = huobiAskPrice;
    }

    public BigDecimal getHuobiBidPrice() {
        return huobiBidPrice;
    }

    public void setHuobiBidPrice(BigDecimal huobiBidPrice) {
        this.huobiBidPrice = huobiBidPrice;
    }

    public Instant getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Instant queryTime) {
        this.queryTime = queryTime;
    }

    public String getFrCoinCode() {
        return frCoinCode;
    }

    public void setFrCoinCode(String frCoinCode) {
        this.frCoinCode = frCoinCode;
    }

    public String getToCoinCode() {
        return toCoinCode;
    }

    public void setToCoinCode(String toCoinCode) {
        this.toCoinCode = toCoinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinPrice coinPrice = (CoinPrice) o;
        return (
            Objects.equals(id, coinPrice.id) &&
            Objects.equals(symbol, coinPrice.symbol) &&
            Objects.equals(frCoin, coinPrice.frCoin) &&
            Objects.equals(toCoin, coinPrice.toCoin) &&
            Objects.equals(bestAskprice, coinPrice.bestAskprice) &&
            Objects.equals(bestBidprice, coinPrice.bestBidprice) &&
            Objects.equals(binanceAskPrice, coinPrice.binanceAskPrice) &&
            Objects.equals(binanceBidPrice, coinPrice.binanceBidPrice) &&
            Objects.equals(huobiAskPrice, coinPrice.huobiAskPrice) &&
            Objects.equals(huobiBidPrice, coinPrice.huobiBidPrice) &&
            Objects.equals(queryTime, coinPrice.queryTime)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            symbol,
            frCoin,
            toCoin,
            bestAskprice,
            bestBidprice,
            binanceAskPrice,
            binanceBidPrice,
            huobiAskPrice,
            huobiBidPrice,
            queryTime
        );
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoinPrice{");
        sb.append("id=").append(id);
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", frCoin=").append(frCoin);
        sb.append(", toCoin=").append(toCoin);
        sb.append(", bestAskprice=").append(bestAskprice);
        sb.append(", bestBidprice=").append(bestBidprice);
        sb.append(", binanceAskPrice=").append(binanceAskPrice);
        sb.append(", binanceBidPrice=").append(binanceBidPrice);
        sb.append(", huobiAskPrice=").append(huobiAskPrice);
        sb.append(", houbiBidPrice=").append(huobiBidPrice);
        sb.append(", queryTime=").append(queryTime);
        sb.append('}');
        return sb.toString();
    }

    public static final class CoinPriceBuilder {

        private Long id;
        private String symbol;
        private Coin frCoin;
        private String frCoinCode;
        private Coin toCoin;
        private String toCoinCode;
        private BigDecimal bestAskprice;
        private BigDecimal bestBidprice;
        private BigDecimal binanceAskPrice;
        private BigDecimal binanceBidPrice;
        private BigDecimal huobiAskPrice;
        private BigDecimal huobiBidPrice;
        private Instant queryTime;

        private CoinPriceBuilder() {}

        public static CoinPriceBuilder aCoinPrice() {
            return new CoinPriceBuilder();
        }

        public CoinPriceBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CoinPriceBuilder withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public CoinPriceBuilder withFrCoin(Coin frCoin) {
            this.frCoin = frCoin;
            return this;
        }

        public CoinPriceBuilder withFrCoinCode(String frCoinCode) {
            this.frCoinCode = frCoinCode;
            return this;
        }

        public CoinPriceBuilder withToCoin(Coin toCoin) {
            this.toCoin = toCoin;
            return this;
        }

        public CoinPriceBuilder withToCoinCode(String toCoinCode) {
            this.toCoinCode = toCoinCode;
            return this;
        }

        public CoinPriceBuilder withBestAskprice(BigDecimal bestAskprice) {
            this.bestAskprice = bestAskprice;
            return this;
        }

        public CoinPriceBuilder withBestBidprice(BigDecimal bestBidprice) {
            this.bestBidprice = bestBidprice;
            return this;
        }

        public CoinPriceBuilder withBinanceAskPrice(BigDecimal binanceAskPrice) {
            this.binanceAskPrice = binanceAskPrice;
            return this;
        }

        public CoinPriceBuilder withBinanceBidPrice(BigDecimal binanceBidPrice) {
            this.binanceBidPrice = binanceBidPrice;
            return this;
        }

        public CoinPriceBuilder withHuobiAskPrice(BigDecimal huobiAskPrice) {
            this.huobiAskPrice = huobiAskPrice;
            return this;
        }

        public CoinPriceBuilder withHuobiBidPrice(BigDecimal houbiBidPrice) {
            this.huobiBidPrice = houbiBidPrice;
            return this;
        }

        public CoinPriceBuilder withQueryTime(Instant queryTime) {
            this.queryTime = queryTime;
            return this;
        }

        public CoinPrice build() {
            CoinPrice coinPrice = new CoinPrice();
            coinPrice.setId(id);
            coinPrice.setSymbol(symbol);
            coinPrice.setFrCoin(frCoin);
            coinPrice.setFrCoinCode(frCoinCode);
            coinPrice.setToCoin(toCoin);
            coinPrice.setToCoinCode(toCoinCode);
            coinPrice.setBestAskprice(bestAskprice);
            coinPrice.setBestBidprice(bestBidprice);
            coinPrice.setBinanceAskPrice(binanceAskPrice);
            coinPrice.setBinanceBidPrice(binanceBidPrice);
            coinPrice.setHuobiAskPrice(huobiAskPrice);
            coinPrice.setHuobiBidPrice(huobiBidPrice);
            coinPrice.setQueryTime(queryTime);
            coinPrice.setBestAskprice(binanceAskPrice.compareTo(huobiAskPrice) > 0 ? binanceAskPrice : huobiAskPrice);
            coinPrice.setBestBidprice(binanceBidPrice.compareTo(huobiBidPrice) > 0 ? huobiBidPrice : binanceBidPrice);
            return coinPrice;
        }
    }
}
