
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Details_Performance {

    @SerializedName("last_30_days")
    @Expose
    private Last30Days_Performance last30Days;
    @SerializedName("yesterday")
    @Expose
    private Yesterday_Performance yesterday;
    @SerializedName("last_7_days")
    @Expose
    private Last7Days_Performance last7Days;
    @SerializedName("last_14_days")
    @Expose
    private Last14Days_Performance last14Days;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Details_Performance() {
    }

    /**
     * 
     * @param yesterday
     * @param last30Days
     * @param last14Days
     * @param last7Days
     */
    public Details_Performance(Last30Days_Performance last30Days, Yesterday_Performance yesterday, Last7Days_Performance last7Days, Last14Days_Performance last14Days) {
        super();
        this.last30Days = last30Days;
        this.yesterday = yesterday;
        this.last7Days = last7Days;
        this.last14Days = last14Days;
    }

    public Last30Days_Performance getLast30Days() {
        return last30Days;
    }

    public void setLast30Days(Last30Days_Performance last30Days) {
        this.last30Days = last30Days;
    }

    public Yesterday_Performance getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday_Performance yesterday) {
        this.yesterday = yesterday;
    }

    public Last7Days_Performance getLast7Days() {
        return last7Days;
    }

    public void setLast7Days(Last7Days_Performance last7Days) {
        this.last7Days = last7Days;
    }

    public Last14Days_Performance getLast14Days() {
        return last14Days;
    }

    public void setLast14Days(Last14Days_Performance last14Days) {
        this.last14Days = last14Days;
    }

}
