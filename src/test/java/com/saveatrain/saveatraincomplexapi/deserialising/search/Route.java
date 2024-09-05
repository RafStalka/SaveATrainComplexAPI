
package com.saveatrain.saveatraincomplexapi.deserialising.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {

    public Route() {

    }

    public Route(OriginStation originStation, DestinationStation destinationStation) {
        this.originStation = originStation;
        this.destinationStation = destinationStation;
    }

    @JsonProperty("origin_station")
    private OriginStation originStation;
    @JsonProperty("destination_station")
    private DestinationStation destinationStation;

    @JsonProperty("origin_station")
    public OriginStation getOriginStation() {
        return originStation;
    }

    @JsonProperty("origin_station")
    public void setOriginStation(OriginStation originStation) {
        this.originStation = originStation;
    }

    @JsonProperty("destination_station")
    public DestinationStation getDestinationStation() {
        return destinationStation;
    }

    @JsonProperty("destination_station")
    public void setDestinationStation(DestinationStation destinationStation) {
        this.destinationStation = destinationStation;
    }

}
