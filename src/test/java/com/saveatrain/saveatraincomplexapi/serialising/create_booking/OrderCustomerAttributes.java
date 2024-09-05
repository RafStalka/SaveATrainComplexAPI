
package com.saveatrain.saveatraincomplexapi.serialising.create_booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCustomerAttributes {

    public OrderCustomerAttributes(String email, String fname, String lname, String gender, String mobile) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.mobile = mobile;
    }

    @JsonProperty("email")
    private String email;
    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
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

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
