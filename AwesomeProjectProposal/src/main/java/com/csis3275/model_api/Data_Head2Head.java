
package com.csis3275.model_api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Data_Head2Head {

    @SerializedName("encounters")
    @Expose
    private List<Encounter_Head2Head> encounters;
    @SerializedName("stats")
    @Expose
    private Stats_Head2Head stats;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data_Head2Head() {
    }

    /**
     * 
     * @param encounters
     * @param stats
     */
    public Data_Head2Head(List<Encounter_Head2Head> encounters, Stats_Head2Head stats) {
        super();
        this.encounters = encounters;
        this.stats = stats;
    }

    public List<Encounter_Head2Head> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter_Head2Head> encounters) {
        this.encounters = encounters;
    }

    public Stats_Head2Head getStats() {
        return stats;
    }

    public void setStats(Stats_Head2Head stats) {
        this.stats = stats;
    }

}
