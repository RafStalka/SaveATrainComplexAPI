package com.saveatrain.saveatraincomplexapi.test.serialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Search {

    @JsonProperty("departure_datetime")
    private String departureDatetime;
    @JsonProperty("searches_passengers_attributes")
    private SearchesPassengersAttributes searchesPassengersAttributes;
    @JsonProperty("route_attributes")
    private RouteAttributes routeAttributes;

    @JsonProperty("departure_datetime")
    public String getDepartureDatetime() {
        return departureDatetime;
    }

    @JsonProperty("departure_datetime")
    public void setDepartureDatetime(String departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    @JsonProperty("searches_passengers_attributes")
    public SearchesPassengersAttributes getSearchesPassengersAttributes() {
        return searchesPassengersAttributes;
    }

    @JsonProperty("searches_passengers_attributes")
    public void setSearchesPassengersAttributes(SearchesPassengersAttributes searchesPassengersAttributes) {
        this.searchesPassengersAttributes = searchesPassengersAttributes;
    }

    @JsonProperty("route_attributes")
    public RouteAttributes getRouteAttributes() {
        return routeAttributes;
    }

    @JsonProperty("route_attributes")
    public void setRouteAttributes(RouteAttributes routeAttributes) {
        this.routeAttributes = routeAttributes;
    }

}
