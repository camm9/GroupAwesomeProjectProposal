
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction_Performance {

    @SerializedName("data")
    @Expose
    private Data_Performance data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Prediction_Performance() {
    }

    /**
     * 
     * @param data
     */
    public Prediction_Performance(Data_Performance data) {
        super();
        this.data = data;
    }

    public Data_Performance getData() {
        return data;
    }

    public void setData(Data_Performance data) {
        this.data = data;
    }

}
