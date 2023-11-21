
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Head2Head {

    @SerializedName("data")
    @Expose
    private Data_Head2Head data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Head2Head() {
    }

    /**
     * 
     * @param data
     */
    public Head2Head(Data_Head2Head data) {
        super();
        this.data = data;
    }

    public Data_Head2Head getData() {
        return data;
    }

    public void setData(Data_Head2Head data) {
        this.data = data;
    }

}
