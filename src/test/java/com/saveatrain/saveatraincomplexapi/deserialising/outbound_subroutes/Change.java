
package com.saveatrain.saveatraincomplexapi.deserialising.outbound_subroutes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Change {

    public Change(List<OriginStationName> originStationNames, List<DestinationStationName> destinationStationNames, String originStationSatUid, String destinationStationSatUid, String departureDatetime, String arrivalDatetime, Train train, String type) {
        this.originStationNames = originStationNames;
        this.destinationStationNames = destinationStationNames;
        this.originStationSatUid = originStationSatUid;
        this.destinationStationSatUid = destinationStationSatUid;
        this.departureDatetime = departureDatetime;
        this.arrivalDatetime = arrivalDatetime;
        this.train = train;
        this.type = type;
    }

    @JsonProperty("origin_station_names")
    private List<OriginStationName> originStationNames;
    @JsonProperty("destination_station_names")
    private List<DestinationStationName> destinationStationNames;
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

    @JsonProperty("origin_station_names")
    public List<OriginStationName> getOriginStationNames() {
        return originStationNames;
    }

    @JsonProperty("origin_station_names")
    public void setOriginStationNames(List<OriginStationName> originStationNames) {
        this.originStationNames = originStationNames;
    }

    @JsonProperty("destination_station_names")
    public List<DestinationStationName> getDestinationStationNames() {
        return destinationStationNames;
    }

    @JsonProperty("destination_station_names")
    public void setDestinationStationNames(List<DestinationStationName> destinationStationNames) {
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
