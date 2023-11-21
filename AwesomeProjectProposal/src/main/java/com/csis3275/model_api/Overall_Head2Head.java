
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Overall_Head2Head {

    @SerializedName("total_goals")
    @Expose
    private Integer totalGoals;
    @SerializedName("over_05")
    @Expose
    private Integer over05;
    @SerializedName("over_25")
    @Expose
    private Integer over25;
    @SerializedName("over_15")
    @Expose
    private Integer over15;
    @SerializedName("over_35")
    @Expose
    private Integer over35;
    @SerializedName("both_teams_scored")
    @Expose
    private Integer bothTeamsScored;
    @SerializedName("avg_goals_per_match")
    @Expose
    private Double avgGoalsPerMatch;
    @SerializedName("num_encounters")
    @Expose
    private Integer numEncounters;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Overall_Head2Head() {
    }

    /**
     * 
     * @param over15
     * @param over05
     * @param numEncounters
     * @param totalGoals
     * @param bothTeamsScored
     * @param over35
     * @param over25
     * @param avgGoalsPerMatch
     */
    public Overall_Head2Head(Integer totalGoals, Integer over05, Integer over25, Integer over15, Integer over35, Integer bothTeamsScored, Double avgGoalsPerMatch, Integer numEncounters) {
        super();
        this.totalGoals = totalGoals;
        this.over05 = over05;
        this.over25 = over25;
        this.over15 = over15;
        this.over35 = over35;
        this.bothTeamsScored = bothTeamsScored;
        this.avgGoalsPerMatch = avgGoalsPerMatch;
        this.numEncounters = numEncounters;
    }
    
    public Overall_Head2Head(Integer totalGoals,Integer bothTeamsScored,Double avgGoalsPerMatch, Integer numEncounters) {
    	super();
    	 this.totalGoals = totalGoals;
    	 this.bothTeamsScored = bothTeamsScored;
         this.avgGoalsPerMatch = avgGoalsPerMatch;
         this.numEncounters = numEncounters;
    }

    public Integer getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(Integer totalGoals) {
        this.totalGoals = totalGoals;
    }

    public Integer getOver05() {
        return over05;
    }

    public void setOver05(Integer over05) {
        this.over05 = over05;
    }

    public Integer getOver25() {
        return over25;
    }

    public void setOver25(Integer over25) {
        this.over25 = over25;
    }

    public Integer getOver15() {
        return over15;
    }

    public void setOver15(Integer over15) {
        this.over15 = over15;
    }

    public Integer getOver35() {
        return over35;
    }

    public void setOver35(Integer over35) {
        this.over35 = over35;
    }

    public Integer getBothTeamsScored() {
        return bothTeamsScored;
    }

    public void setBothTeamsScored(Integer bothTeamsScored) {
        this.bothTeamsScored = bothTeamsScored;
    }

    public Double getAvgGoalsPerMatch() {
        return avgGoalsPerMatch;
    }

    public void setAvgGoalsPerMatch(Double avgGoalsPerMatch) {
        this.avgGoalsPerMatch = avgGoalsPerMatch;
    }

    public Integer getNumEncounters() {
        return numEncounters;
    }

    public void setNumEncounters(Integer numEncounters) {
        this.numEncounters = numEncounters;
    }

}
