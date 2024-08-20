package com.saveatrain.saveatraincomplexapi.test.serialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAgentSessionPOJO {

    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    public SalesAgentSessionPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    /*@JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }*/

}
