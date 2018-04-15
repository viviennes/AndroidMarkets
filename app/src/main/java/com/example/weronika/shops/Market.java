package com.example.weronika.shops;

/**
 * Created by Weronika on 15.04.2018.
 */

public class Market {
    private String instrumentName;
    private String instrumentVersion;
    private String displayPeriod;
    private String epic;
    private String exchangeId;
    private String displayBid;
    private String displayOffer;
    private long updateTime;
    private String netChange;
    private boolean scaled;
    private int timezoneOffset;

    private Market() {
    }


    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentVersion() {
        return instrumentVersion;
    }

    public void setInstrumentVersion(String instrumentVersion) {
        this.instrumentVersion = instrumentVersion;
    }

    public String getDisplayPeriod() {
        return displayPeriod;
    }

    public void setDisplayPeriod(String displayPeriod) {
        this.displayPeriod = displayPeriod;
    }

    public String getEpic() {
        return epic;
    }

    public void setEpic(String epic) {
        this.epic = epic;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getDisplayBid() {
        return displayBid;
    }

    public void setDisplayBid(String displayBid) {
        this.displayBid = displayBid;
    }

    public String getDisplayOffer() {
        return displayOffer;
    }

    public void setDisplayOffer(String displayOffer) {
        this.displayOffer = displayOffer;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getNetChange() {
        return netChange;
    }

    public void setNetChange(String netChange) {
        this.netChange = netChange;
    }

    public boolean isScaled() {
        return scaled;
    }

    public void setScaled(boolean scaled) {
        this.scaled = scaled;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }
}
