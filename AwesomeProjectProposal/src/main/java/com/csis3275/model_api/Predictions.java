
package com.csis3275.model_api;

import java.util.List;


import org.springframework.validation.annotation.Validated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Predictions {

    @SerializedName("data")
    @Expose
    private List<Datum> data;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "Predictions [data=" + data + "]";
	}

    
}
