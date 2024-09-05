
package com.saveatrain.saveatraincomplexapi.deserialising.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route__1 {

    public Route__1() {

    }

    public Route__1(OriginStation__1 originStation, DestinationStation__1 destinationStation) {
        this.originStation = originStation;
        this.destinationStation = destinationStation;
    }

    @JsonProperty("origin_station")
    private OriginStation__1 originStation;
    @JsonProperty("destination_station")
    private DestinationStation__1 destinationStation;

    @JsonProperty("origin_station")
    public OriginStation__1 getOriginStation() {
        return originStation;
    }

    @JsonProperty("origin_station")
    public void setOriginStation(OriginStation__1 originStation) {
        this.originStation = originStation;
    }

    @JsonProperty("destination_station")
    public DestinationStation__1 getDestinationStation() {
        return destinationStation;
    }

    @JsonProperty("destination_station")
    public void setDestinationStation(DestinationStation__1 destinationStation) {
        this.destinationStation = destinationStation;
    }

}
