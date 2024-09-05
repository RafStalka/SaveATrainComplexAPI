
package com.saveatrain.saveatraincomplexapi.serialising.create_booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {

    public Booking(String searchIdentifier, OrderCustomerAttributes orderCustomerAttributes, PassengerDetail passengerDetail, SeatPreferenceAttributes seatPreferenceAttributes) {
        this.searchIdentifier = searchIdentifier;
        this.orderCustomerAttributes = orderCustomerAttributes;
        this.passengerDetail = passengerDetail;
        this.seatPreferenceAttributes = seatPreferenceAttributes;
    }

    @JsonProperty("search_identifier")
    private String searchIdentifier;
    @JsonProperty("order_customer_attributes")
    private OrderCustomerAttributes orderCustomerAttributes;
    @JsonProperty("passengers_attributes")
    private PassengerDetail passengerDetail;
    @JsonProperty("seat_preference_attributes")
    private SeatPreferenceAttributes seatPreferenceAttributes;

    @JsonProperty("search_identifier")
    public String getSearchIdentifier() {
        return searchIdentifier;
    }

    @JsonProperty("search_identifier")
    public void setSearchIdentifier(String searchIdentifier) {
        this.searchIdentifier = searchIdentifier;
    }

    @JsonProperty("order_customer_attributes")
    public OrderCustomerAttributes getOrderCustomerAttributes() {
        return orderCustomerAttributes;
    }

    @JsonProperty("order_customer_attributes")
    public void setOrderCustomerAttributes(OrderCustomerAttributes orderCustomerAttributes) {
        this.orderCustomerAttributes = orderCustomerAttributes;
    }

    @JsonProperty("passengers_attributes")
    public PassengerDetail getPassengersAttributes() {
        return passengerDetail;
    }

    @JsonProperty("passengers_attributes")
    public void setPassengersAttributes(PassengerDetail passengerDetail) {
        this.passengerDetail = passengerDetail;
    }

    @JsonProperty("seat_preference_attributes")
    public SeatPreferenceAttributes getSeatPreferenceAttributes() {
        return seatPreferenceAttributes;
    }

    @JsonProperty("seat_preference_attributes")
    public void setSeatPreferenceAttributes(SeatPreferenceAttributes seatPreferenceAttributes) {
        this.seatPreferenceAttributes = seatPreferenceAttributes;
    }

}
