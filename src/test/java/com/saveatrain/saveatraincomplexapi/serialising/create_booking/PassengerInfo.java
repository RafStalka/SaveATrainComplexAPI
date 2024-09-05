
package com.saveatrain.saveatraincomplexapi.serialising.create_booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassengerInfo {

    public PassengerInfo(String title, String fname, String lname, String birthdate, String country, String gender, String idNumber, Integer idType, String idCountry, String idExpiry, PassengerTypeAttributes passengerTypeAttributes) {
        this.title = title;
        this.fname = fname;
        this.lname = lname;
        this.birthdate = birthdate;
        this.country = country;
        this.gender = gender;
        this.idNumber = idNumber;
        this.idType = idType;
        this.idCountry = idCountry;
        this.idExpiry = idExpiry;
        this.passengerTypeAttributes = passengerTypeAttributes;
    }

    @JsonProperty("title")
    private String title;
    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("country")
    private String country;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("id_number")
    private String idNumber;
    @JsonProperty("id_type")
    private Integer idType;
    @JsonProperty("id_country")
    private String idCountry;
    @JsonProperty("id_expiry")
    private String idExpiry;
    @JsonProperty("passenger_type_attributes")
    private PassengerTypeAttributes passengerTypeAttributes;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("fname")
    public String getFname() {
        return fname;
    }

    @JsonProperty("fname")
    public void setFname(String fname) {
        this.fname = fname;
    }

    @JsonProperty("lname")
    public String getLname() {
        return lname;
    }

    @JsonProperty("lname")
    public void setLname(String lname) {
        this.lname = lname;
    }

    @JsonProperty("birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    @JsonProperty("birthdate")
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("id_number")
    public String getIdNumber() {
        return idNumber;
    }

    @JsonProperty("id_number")
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @JsonProperty("id_type")
    public Integer getIdType() {
        return idType;
    }

    @JsonProperty("id_type")
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @JsonProperty("id_country")
    public String getIdCountry() {
        return idCountry;
    }

    @JsonProperty("id_country")
    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    @JsonProperty("id_expiry")
    public String getIdExpiry() {
        return idExpiry;
    }

    @JsonProperty("id_expiry")
    public void setIdExpiry(String idExpiry) {
        this.idExpiry = idExpiry;
    }

    @JsonProperty("passenger_type_attributes")
    public PassengerTypeAttributes getPassengerTypeAttributes() {
        return passengerTypeAttributes;
    }

    @JsonProperty("passenger_type_attributes")
    public void setPassengerTypeAttributes(PassengerTypeAttributes passengerTypeAttributes) {
        this.passengerTypeAttributes = passengerTypeAttributes;
    }

}
