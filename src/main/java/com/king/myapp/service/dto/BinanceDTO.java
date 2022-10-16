package com.king.myapp.service.dto;

public class BinanceDTO {

    public String symbol;
    private String bidPrice;
    private String bidQty;
    private String askPrice;
    private String askQty;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public Double getBidPriceDouble() {
        return Double.valueOf(bidPrice);
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidQty() {
        return bidQty;
    }

    public Double getBidQtyDouble() {
        return Double.valueOf(bidQty);
    }

    public void setBidQty(String bidQty) {
        this.bidQty = bidQty;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public Double getAskPriceDouble() {
        return Double.valueOf(askPrice);
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    public String getAskQty() {
        return askQty;
    }

    public Double getAskQtyDouble() {
        return Double.valueOf(askQty);
    }

    public void setAskQty(String askQty) {
        this.askQty = askQty;
    }
}
