
package com.csis3275.model_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats_Head2Head {

    @SerializedName("away_team")
    @Expose
    private AwayTeam_Head2Head awayTeam;
    @SerializedName("home_team")
    @Expose
    private HomeTeam_Head2Head homeTeam;
    @SerializedName("overall")
    @Expose
    private Overall_Head2Head overall;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats_Head2Head() {
    }

    /**
     * 
     * @param awayTeam
     * @param homeTeam
     * @param overall
     */
    public Stats_Head2Head(AwayTeam_Head2Head awayTeam, HomeTeam_Head2Head homeTeam, Overall_Head2Head overall) {
        super();
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.overall = overall;
    }

    public AwayTeam_Head2Head getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam_Head2Head awayTeam) {
        this.awayTeam = awayTeam;
    }

    public HomeTeam_Head2Head getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam_Head2Head homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Overall_Head2Head getOverall() {
        return overall;
    }

    public void setOverall(Overall_Head2Head overall) {
        this.overall = overall;
    }

}
