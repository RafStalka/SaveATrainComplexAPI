
package com.saveatrain.saveatraincomplexapi.deserialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    public Result() {

    }

    public Result(Integer id, Route__1 route, String departureDatetime, String arrivalDatetime, Integer duration, String bestPrice, String kindOf, Integer changesCount, List<String> logo, String type, String searchIdentifier) {
        this.id = id;
        this.route = route;
        this.departureDatetime = departureDatetime;
        this.arrivalDatetime = arrivalDatetime;
        this.duration = duration;
        this.bestPrice = bestPrice;
        this.kindOf = kindOf;
        this.changesCount = changesCount;
        this.logo = logo;
        this.type = type;
        this.searchIdentifier = searchIdentifier;
    }

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("route")
    private Route__1 route;
    @JsonProperty("departure_datetime")
    private String departureDatetime;
    @JsonProperty("arrival_datetime")
    private String arrivalDatetime;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("best_price")
    private String bestPrice;
    @JsonProperty("kind_of")
    private String kindOf;
    @JsonProperty("changes_count")
    private Integer changesCount;
    @JsonProperty("logo")
    private List<String> logo;
    @JsonProperty("type")
    private String type;
    @JsonProperty("search_identifier")
    private String searchIdentifier;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("route")
    public Route__1 getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(Route__1 route) {
        this.route = route;
    }

    @JsonProperty("departure_datetime")
    public String getDepartureDatetime() {
        return departureDatetime;
    }

    @JsonProperty("departure_datetime")
    public void setDepartureDatetime(String departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    @JsonProperty("arrival_datetime")
    public String getArrivalDatetime() {
        return arrivalDatetime;
    }

    @JsonProperty("arrival_datetime")
    public void setArrivalDatetime(String arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("best_price")
    public String getBestPrice() {
        return bestPrice;
    }

    @JsonProperty("best_price")
    public void setBestPrice(String bestPrice) {
        this.bestPrice = bestPrice;
    }

    @JsonProperty("kind_of")
    public String getKindOf() {
        return kindOf;
    }

    @JsonProperty("kind_of")
    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    @JsonProperty("changes_count")
    public Integer getChangesCount() {
        return changesCount;
    }

    @JsonProperty("changes_count")
    public void setChangesCount(Integer changesCount) {
        this.changesCount = changesCount;
    }

    @JsonProperty("logo")
    public List<String> getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(List<String> logo) {
        this.logo = logo;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("search_identifier")
    public String getSearchIdentifier() {
        return searchIdentifier;
    }

    @JsonProperty("search_identifier")
    public void setSearchIdentifier(String searchIdentifier) {
        this.searchIdentifier = searchIdentifier;
    }

}
