
package com.csis3275.model_api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Odds {

	@SerializedName("1")
	@Expose
	private Double _1;
	@SerializedName("2")
	@Expose
	private Double _2;
	@SerializedName("12")
	@Expose
	private Double _12;
	@SerializedName("X")
	@Expose
	private Double x;
	@SerializedName("1X")
	@Expose
	private Double _1x;
	@SerializedName("X2")
	@Expose
	private Double x2;
	
	public Odds(){
		
	}
	
	public Odds(Double _1, Double _2, Double _12, Double x, Double _1x, Double x2) {
		super();
		this._1 = _1;
		this._2 = _2;
		this._12 = _12;
		this.x = x;
		this._1x = _1x;
		this.x2 = x2;
	}

	public Double get1() {
		return _1;
	}

	public void set1(Double _1) {
		this._1 = _1;
	}

	public Double get2() {
		return _2;
	}

	public void set2(Double _2) {
		this._2 = _2;
	}

	public Double get12() {
		return _12;
	}

	public void set12(Double _12) {
		this._12 = _12;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double get1x() {
		return _1x;
	}

	public void set1x(Double _1x) {
		this._1x = _1x;
	}

	public Double getX2() {
		return x2;
	}

	public void setX2(Double x2) {
		this.x2 = x2;
	}

	public Object getType() {
		// TODO Auto-generated method stub
		return Odds.class;
	}

}
