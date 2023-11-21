
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Last7Days_Performance {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("won")
    @Expose
    private Integer won;
    @SerializedName("lost")
    @Expose
    private Integer lost;
    @SerializedName("postponed")
    @Expose
    private Integer postponed;
    @SerializedName("pending")
    @Expose
    private Integer pending;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Last7Days_Performance() {
    }

    /**
     * 
     * @param total
     * @param lost
     * @param won
     * @param pending
     * @param postponed
     */
    public Last7Days_Performance(Integer total, Integer won, Integer lost, Integer postponed, Integer pending) {
        super();
        this.total = total;
        this.won = won;
        this.lost = lost;
        this.postponed = postponed;
        this.pending = pending;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getPostponed() {
        return postponed;
    }

    public void setPostponed(Integer postponed) {
        this.postponed = postponed;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

}
