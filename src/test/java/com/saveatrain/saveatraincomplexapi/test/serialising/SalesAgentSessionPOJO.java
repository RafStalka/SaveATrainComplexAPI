package com.saveatrain.saveatraincomplexapi.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesAgentSessionPOJO {

    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    public SalesAgentSessionPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
