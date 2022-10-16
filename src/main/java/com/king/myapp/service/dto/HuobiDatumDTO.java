package com.king.myapp.service.dto;

public class HuobiDatumDTO {

    private String symbol;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double amount;
    private Double vol;
    private Integer count;
    private Double bid;
    private Double bidSize;
    private Double ask;
    private Double askSize;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getBidSize() {
        return bidSize;
    }

    public void setBidSize(Double bidSize) {
        this.bidSize = bidSize;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getAskSize() {
        return askSize;
    }

    public void setAskSize(Double askSize) {
        this.askSize = askSize;
    }
}
