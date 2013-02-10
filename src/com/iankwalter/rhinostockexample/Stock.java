package com.iankwalter.rhinostockexample;

/**
 * Models a Stock for the purpose of this example.
 *
 * @author Ian Kennington Walter
 */
public class Stock {

    Double netIncome;
    Double totalDebt;
    Double totalCash;
    Double marketCap;
    boolean isUndervalued;

    public Double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Double netIncome) {
        this.netIncome = netIncome;
    }

    public Double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(Double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(Double totalCash) {
        this.totalCash = totalCash;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public boolean isUndervalued() {
        return isUndervalued;
    }

    public void setUndervalued(boolean undervalued) {
        isUndervalued = undervalued;
    }
}
