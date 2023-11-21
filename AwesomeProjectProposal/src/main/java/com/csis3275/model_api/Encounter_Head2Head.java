
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Encounter_Head2Head {

    @SerializedName("fulltime_result")
    @Expose
    private String fulltimeResult;
    @SerializedName("home_team")
    @Expose
    private String homeTeam;
    @SerializedName("first_half_result")
    @Expose
    private String firstHalfResult;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("away_team")
    @Expose
    private String awayTeam;
    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("competition_name")
    @Expose
    private String competitionName;
    @SerializedName("competition_cluster")
    @Expose
    private String competitionCluster;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Encounter_Head2Head() {
    }

    /**
     * 
     * @param competitionCluster
     * @param awayTeam
     * @param fulltimeResult
     * @param competitionName
     * @param homeTeam
     * @param season
     * @param firstHalfResult
     * @param startDate
     */
    public Encounter_Head2Head(String fulltimeResult, String homeTeam, String firstHalfResult, String startDate, String awayTeam, String season, String competitionName, String competitionCluster) {
        super();
        this.fulltimeResult = fulltimeResult;
        this.homeTeam = homeTeam;
        this.firstHalfResult = firstHalfResult;
        this.startDate = startDate;
        this.awayTeam = awayTeam;
        this.season = season;
        this.competitionName = competitionName;
        this.competitionCluster = competitionCluster;
    }

    public String getFulltimeResult() {
        return fulltimeResult;
    }

    public void setFulltimeResult(String fulltimeResult) {
        this.fulltimeResult = fulltimeResult;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getFirstHalfResult() {
        return firstHalfResult;
    }

    public void setFirstHalfResult(String firstHalfResult) {
        this.firstHalfResult = firstHalfResult;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionCluster() {
        return competitionCluster;
    }

    public void setCompetitionCluster(String competitionCluster) {
        this.competitionCluster = competitionCluster;
    }

}
