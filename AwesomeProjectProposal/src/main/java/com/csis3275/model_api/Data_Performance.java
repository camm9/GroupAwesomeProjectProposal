
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Data_Performance {

    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("accuracy")
    @Expose
    private Accuracy_Performance accuracy;
    @SerializedName("details")
    @Expose
    private Details_Performance details;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data_Performance() {
    }

    /**
     * 
     * @param market
     * @param accuracy
     * @param details
     */
    public Data_Performance(String market, Accuracy_Performance accuracy, Details_Performance details) {
        super();
        this.market = market;
        this.accuracy = accuracy;
        this.details = details;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Accuracy_Performance getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Accuracy_Performance accuracy) {
        this.accuracy = accuracy;
    }

    public Details_Performance getDetails() {
        return details;
    }

    public void setDetails(Details_Performance details) {
        this.details = details;
    }

}
