
package com.saveatrain.saveatraincomplexapi.serialising.create_booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassengerDetail {

    private static final String PASSENGER_ATTRIBUTE_0_JSON_PROPERTY = "0";

    @JsonProperty(PASSENGER_ATTRIBUTE_0_JSON_PROPERTY)
    private PassengerDetail firstPassenger;

    @JsonProperty(PASSENGER_ATTRIBUTE_0_JSON_PROPERTY)
    public PassengerDetail getFirstPassenger() {
        return firstPassenger;
    }

    @JsonProperty(PASSENGER_ATTRIBUTE_0_JSON_PROPERTY)
    public void setFirstPassenger(PassengerDetail firstPassenger) {
        this.firstPassenger = firstPassenger;
    }

}
