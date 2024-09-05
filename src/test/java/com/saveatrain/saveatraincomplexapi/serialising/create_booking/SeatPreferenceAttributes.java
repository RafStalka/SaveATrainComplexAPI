
package com.saveatrain.saveatraincomplexapi.serialising.create_booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeatPreferenceAttributes {

    private static final String SEAT_PREF_OUTBOUND_JSON_PROPERTY = "seat_preference_outbound";
    private static final String SEAT_PREF_INBOUND_JSON_PROPERTY = "seat_preference_inbound";

    @JsonProperty(SEAT_PREF_OUTBOUND_JSON_PROPERTY)
    private String seatPreferenceOutbound;

    @JsonProperty(SEAT_PREF_INBOUND_JSON_PROPERTY)
    private String seatPreferenceInbound;

    public SeatPreferenceAttributes(String seatPreferenceOutbound, String seatPreferenceInbound) {
        this.seatPreferenceOutbound = seatPreferenceOutbound;
        this.seatPreferenceInbound = seatPreferenceInbound;
    }

    public String getSeatPreferenceOutbound() {
        return seatPreferenceOutbound;
    }

    public void setSeatPreferenceOutbound(String seatPreferenceOutbound) {
        this.seatPreferenceOutbound = seatPreferenceOutbound;
    }

    public String getSeatPreferenceInbound() {
        return seatPreferenceInbound;
    }

    public void setSeatPreferenceInbound(String seatPreferenceInbound) {
        this.seatPreferenceInbound = seatPreferenceInbound;
    }

}
