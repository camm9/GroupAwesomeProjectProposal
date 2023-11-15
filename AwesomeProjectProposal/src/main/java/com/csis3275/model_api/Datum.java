package com.csis3275.model_api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Datum {

	@SerializedName("home_team")
	@Expose
	private String homeTeam;
	@SerializedName("away_team")
	@Expose
	private String awayTeam;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("market")
	@Expose
	private String market;
	@SerializedName("competition_name")
	@Expose
	private String competitionName;
	@SerializedName("prediction")
	@Expose
	private String prediction;
	@SerializedName("competition_cluster")
	@Expose
	private String competitionCluster;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("federation")
	@Expose
	private String federation;
	@SerializedName("is_expired")
	@Expose
	private Boolean isExpired;
	@SerializedName("season")
	@Expose
	private String season;
	@SerializedName("result")
	@Expose
	private String result;
	@SerializedName("start_date")
	@Expose
	private String startDate;
	@SerializedName("last_update_at")
	@Expose
	private String lastUpdateAt;
	@SerializedName("odds")
	@Expose
	private Odds odds;
	@SerializedName("probability")
	@Expose
	private String probability;
	
	

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}

	public String getCompetitionCluster() {
		return competitionCluster;
	}

	public void setCompetitionCluster(String competitionCluster) {
		this.competitionCluster = competitionCluster;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFederation() {
		return federation;
	}

	public void setFederation(String federation) {
		this.federation = federation;
	}

	public Boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLastUpdateAt() {
		return lastUpdateAt;
	}

	public void setLastUpdateAt(String lastUpdateAt) {
		this.lastUpdateAt = lastUpdateAt;
	}

	public Odds getOdds() {
		return odds;
	}

	public void setOdds(Odds odds) {
		this.odds = odds;
	}

	public Datum() {
		
	}
	
	public Datum(Integer id, String homeTeam, String awayTeam) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public Datum(Integer id, String homeTeam, String awayTeam, String federation, String competitionCluster) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.federation = federation;
		this.competitionCluster = competitionCluster;
	}
	
	public Datum(Integer id, String homeTeam, String awayTeam, String federation, String competitionCluster, String prediction) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.federation = federation;
		this.competitionCluster = competitionCluster;
		this.prediction = prediction;
	}
	
	
	public Datum(Integer id, String homeTeam, String awayTeam, String federation, String competitionCluster, String prediction, String status) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.federation = federation;
		this.competitionCluster = competitionCluster;
		this.prediction = prediction;
		this.status = status;
	}

	public Datum(Integer id, String homeTeam, String awayTeam, Odds odds) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.odds = odds;
	}
	
	public Datum(Integer id, String homeTeam, String awayTeam, String prediction, Odds odds) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.prediction = prediction;
		this.odds = odds;
	}

	
}