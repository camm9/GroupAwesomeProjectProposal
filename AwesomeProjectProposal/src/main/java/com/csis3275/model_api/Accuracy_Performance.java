
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Accuracy_Performance {

    @SerializedName("last_30_days")
    @Expose
    private Double last30Days;
    @SerializedName("yesterday")
    @Expose
    private Double yesterday;
    @SerializedName("last_7_days")
    @Expose
    private Double last7Days;
    @SerializedName("last_14_days")
    @Expose
    private Double last14Days;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Accuracy_Performance() {
    }

    /**
     * 
     * @param yesterday
     * @param last30Days
     * @param last14Days
     * @param last7Days
     */
    public Accuracy_Performance(Double last30Days, Double yesterday, Double last7Days, Double last14Days) {
        super();
        this.last30Days = last30Days;
        this.yesterday = yesterday;
        this.last7Days = last7Days;
        this.last14Days = last14Days;
    }

    public Double getLast30Days() {
        return last30Days;
    }

    public void setLast30Days(Double last30Days) {
        this.last30Days = last30Days;
    }

    public Double getYesterday() {
        return yesterday;
    }

    public void setYesterday(Double yesterday) {
        this.yesterday = yesterday;
    }

    public Double getLast7Days() {
        return last7Days;
    }

    public void setLast7Days(Double last7Days) {
        this.last7Days = last7Days;
    }

    public Double getLast14Days() {
        return last14Days;
    }

    public void setLast14Days(Double last14Days) {
        this.last14Days = last14Days;
    }

}
