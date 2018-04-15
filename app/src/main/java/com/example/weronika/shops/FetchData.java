package com.example.weronika.shops;

import java.util.List;

/**
 * Created by Weronika on 15.04.2018.
 */

public class FetchData {

    private List<Market> markets;
    private String chartFormat;
    private  String lightstreamerEndpoint;
    private String configuration;

    public FetchData() {
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }

    public String getChartFormat() {
        return chartFormat;
    }

    public void setChartFormat(String chartFormat) {
        this.chartFormat = chartFormat;
    }

    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    public void setLightstreamerEndpoint(String lightstreamerEndpoint) {
        this.lightstreamerEndpoint = lightstreamerEndpoint;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
