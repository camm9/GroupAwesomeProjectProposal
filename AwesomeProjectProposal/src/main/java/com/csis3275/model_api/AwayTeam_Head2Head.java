
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AwayTeam_Head2Head {

    @SerializedName("first_half_draw")
    @Expose
    private Integer firstHalfDraw;
    @SerializedName("lost")
    @Expose
    private Integer lost;
    @SerializedName("avg_bookie_win_chance")
    @Expose
    private Double avgBookieWinChance;
    @SerializedName("first_half_win")
    @Expose
    private Integer firstHalfWin;
    @SerializedName("avg_bookie_lose_chance")
    @Expose
    private Double avgBookieLoseChance;
    @SerializedName("avg_bookie_draw_chance")
    @Expose
    private Double avgBookieDrawChance;
    @SerializedName("goals_conceived")
    @Expose
    private Integer goalsConceived;
    @SerializedName("avg_goals_conceived")
    @Expose
    private Double avgGoalsConceived;
    @SerializedName("won")
    @Expose
    private Integer won;
    @SerializedName("first_half_lost")
    @Expose
    private Integer firstHalfLost;
    @SerializedName("draw")
    @Expose
    private Integer draw;
    @SerializedName("goals_scored")
    @Expose
    private Integer goalsScored;
    @SerializedName("clean_sheet")
    @Expose
    private Integer cleanSheet;
    @SerializedName("avg_goals_scored")
    @Expose
    private Double avgGoalsScored;
    @SerializedName("team_name")
    @Expose
    private String teamName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AwayTeam_Head2Head() {
    }

    /**
     * 
     * @param firstHalfLost
     * @param teamName
     * @param firstHalfWin
     * @param firstHalfDraw
     * @param avgGoalsConceived
     * @param avgBookieWinChance
     * @param cleanSheet
     * @param draw
     * @param goalsScored
     * @param goalsConceived
     * @param avgGoalsScored
     * @param lost
     * @param avgBookieDrawChance
     * @param won
     * @param avgBookieLoseChance
     */
    public AwayTeam_Head2Head(Integer firstHalfDraw, Integer lost, Double avgBookieWinChance, Integer firstHalfWin, Double avgBookieLoseChance, Double avgBookieDrawChance, Integer goalsConceived, Double avgGoalsConceived, Integer won, Integer firstHalfLost, Integer draw, Integer goalsScored, Integer cleanSheet, Double avgGoalsScored, String teamName) {
        super();
        this.firstHalfDraw = firstHalfDraw;
        this.lost = lost;
        this.avgBookieWinChance = avgBookieWinChance;
        this.firstHalfWin = firstHalfWin;
        this.avgBookieLoseChance = avgBookieLoseChance;
        this.avgBookieDrawChance = avgBookieDrawChance;
        this.goalsConceived = goalsConceived;
        this.avgGoalsConceived = avgGoalsConceived;
        this.won = won;
        this.firstHalfLost = firstHalfLost;
        this.draw = draw;
        this.goalsScored = goalsScored;
        this.cleanSheet = cleanSheet;
        this.avgGoalsScored = avgGoalsScored;
        this.teamName = teamName;
    }

    public Integer getFirstHalfDraw() {
        return firstHalfDraw;
    }

    public void setFirstHalfDraw(Integer firstHalfDraw) {
        this.firstHalfDraw = firstHalfDraw;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Double getAvgBookieWinChance() {
        return avgBookieWinChance;
    }

    public void setAvgBookieWinChance(Double avgBookieWinChance) {
        this.avgBookieWinChance = avgBookieWinChance;
    }

    public Integer getFirstHalfWin() {
        return firstHalfWin;
    }

    public void setFirstHalfWin(Integer firstHalfWin) {
        this.firstHalfWin = firstHalfWin;
    }

    public Double getAvgBookieLoseChance() {
        return avgBookieLoseChance;
    }

    public void setAvgBookieLoseChance(Double avgBookieLoseChance) {
        this.avgBookieLoseChance = avgBookieLoseChance;
    }

    public Double getAvgBookieDrawChance() {
        return avgBookieDrawChance;
    }

    public void setAvgBookieDrawChance(Double avgBookieDrawChance) {
        this.avgBookieDrawChance = avgBookieDrawChance;
    }

    public Integer getGoalsConceived() {
        return goalsConceived;
    }

    public void setGoalsConceived(Integer goalsConceived) {
        this.goalsConceived = goalsConceived;
    }

    public Double getAvgGoalsConceived() {
        return avgGoalsConceived;
    }

    public void setAvgGoalsConceived(Double avgGoalsConceived) {
        this.avgGoalsConceived = avgGoalsConceived;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getFirstHalfLost() {
        return firstHalfLost;
    }

    public void setFirstHalfLost(Integer firstHalfLost) {
        this.firstHalfLost = firstHalfLost;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(Integer cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public Double getAvgGoalsScored() {
        return avgGoalsScored;
    }

    public void setAvgGoalsScored(Double avgGoalsScored) {
        this.avgGoalsScored = avgGoalsScored;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
