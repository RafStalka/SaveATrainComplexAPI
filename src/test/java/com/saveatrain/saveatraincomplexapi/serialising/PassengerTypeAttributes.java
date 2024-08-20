package com.saveatrain.saveatraincomplexapi.serialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassengerTypeAttributes {

    public PassengerTypeAttributes() {
    }

    public PassengerTypeAttributes(String type) {
        this.type = type;
    }

    @JsonProperty("type")
    private String type;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
