
package com.saveatrain.saveatraincomplexapi.deserialising.outbound_subroutes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Change {
    @JsonProperty("origin_station_names")
    private List<StationName> originStationNames;

    @JsonProperty("destination_station_names")
    private List<StationName> destinationStationNames;

    @JsonProperty("origin_station_sat_uid")
    private String originStationSatUid;

    @JsonProperty("destination_station_sat_uid")
    private String destinationStationSatUid;

    @JsonProperty("departure_datetime")
    private String departureDatetime;

    @JsonProperty("arrival_datetime")
    private String arrivalDatetime;

    @JsonProperty("train")
    private Train train;

    @JsonProperty("type")
    private String type;

    // Gettery i Settery
    @JsonProperty("origin_station_names")
    public List<StationName> getOriginStationNames() {
        return originStationNames;
    }

    @JsonProperty("origin_station_names")
    public void setOriginStationNames(List<StationName> originStationNames) {
        this.originStationNames = originStationNames;
    }

    @JsonProperty("destination_station_names")
    public List<StationName> getDestinationStationNames() {
        return destinationStationNames;
    }

    @JsonProperty("destination_station_names")
    public void setDestinationStationNames(List<StationName> destinationStationNames) {
        this.destinationStationNames = destinationStationNames;
    }

    @JsonProperty("origin_station_sat_uid")
    public String getOriginStationSatUid() {
        return originStationSatUid;
    }

    @JsonProperty("origin_station_sat_uid")
    public void setOriginStationSatUid(String originStationSatUid) {
        this.originStationSatUid = originStationSatUid;
    }

    @JsonProperty("destination_station_sat_uid")
    public String getDestinationStationSatUid() {
        return destinationStationSatUid;
    }

    @JsonProperty("destination_station_sat_uid")
    public void setDestinationStationSatUid(String destinationStationSatUid) {
        this.destinationStationSatUid = destinationStationSatUid;
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

    @JsonProperty("train")
    public Train getTrain() {
        return train;
    }

    @JsonProperty("train")
    public void setTrain(Train train) {
        this.train = train;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
}
