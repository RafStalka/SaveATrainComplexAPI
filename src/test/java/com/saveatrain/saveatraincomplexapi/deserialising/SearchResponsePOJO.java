
package com.saveatrain.saveatraincomplexapi.deserialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResponsePOJO {

    public SearchResponsePOJO() {

    }

    public SearchResponsePOJO(String identifier, Boolean complete, Route route, String departureDatetime, Object returnDepartureDatetime, Integer expirationTimeLeft, List<Result> results, Boolean isBeginning, Boolean isEnding) {
        this.identifier = identifier;
        this.complete = complete;
        this.route = route;
        this.departureDatetime = departureDatetime;
        this.returnDepartureDatetime = returnDepartureDatetime;
        this.expirationTimeLeft = expirationTimeLeft;
        this.results = results;
        this.isBeginning = isBeginning;
        this.isEnding = isEnding;
    }

    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("complete")
    private Boolean complete;
    @JsonProperty("route")
    private Route route;
    @JsonProperty("departure_datetime")
    private String departureDatetime;
    @JsonProperty("return_departure_datetime")
    private Object returnDepartureDatetime;
    @JsonProperty("expiration_time_left")
    private Integer expirationTimeLeft;
    @JsonProperty("results")
    private List<Result> results;
    @JsonProperty("is_beginning")
    private Boolean isBeginning;
    @JsonProperty("is_ending")
    private Boolean isEnding;

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("complete")
    public Boolean getComplete() {
        return complete;
    }

    @JsonProperty("complete")
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @JsonProperty("route")
    public Route getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(Route route) {
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

    @JsonProperty("return_departure_datetime")
    public Object getReturnDepartureDatetime() {
        return returnDepartureDatetime;
    }

    @JsonProperty("return_departure_datetime")
    public void setReturnDepartureDatetime(Object returnDepartureDatetime) {
        this.returnDepartureDatetime = returnDepartureDatetime;
    }

    @JsonProperty("expiration_time_left")
    public Integer getExpirationTimeLeft() {
        return expirationTimeLeft;
    }

    @JsonProperty("expiration_time_left")
    public void setExpirationTimeLeft(Integer expirationTimeLeft) {
        this.expirationTimeLeft = expirationTimeLeft;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonProperty("is_beginning")
    public Boolean getIsBeginning() {
        return isBeginning;
    }

    @JsonProperty("is_beginning")
    public void setIsBeginning(Boolean isBeginning) {
        this.isBeginning = isBeginning;
    }

    @JsonProperty("is_ending")
    public Boolean getIsEnding() {
        return isEnding;
    }

    @JsonProperty("is_ending")
    public void setIsEnding(Boolean isEnding) {
        this.isEnding = isEnding;
    }

}
