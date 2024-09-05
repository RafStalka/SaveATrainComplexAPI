package com.saveatrain.saveatraincomplexapi.serialising.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DestinationStationAttributes {

    public DestinationStationAttributes() {
    }

    public DestinationStationAttributes(String uid) {
        this.uid = uid;
    }

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

}
