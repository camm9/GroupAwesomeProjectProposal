package com.csis3275.model_api;

public class Match {
	String matchID;
	String homeTeam;
	String awayTeam;
	
	Match(){
		
	}
	
	public Match(String matchID, String homeTeam, String awayTeam){
		this.matchID = matchID;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public String getMatchID() {
		return matchID;
	}

	public void setMatchID(String matchID) {
		this.matchID = matchID;
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
	
	

}
