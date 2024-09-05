
package com.saveatrain.saveatraincomplexapi.deserialising.outbound_subroutes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DestinationStationName {

    public DestinationStationName(Language__1 language, String name) {
        this.language = language;
        this.name = name;
    }

    @JsonProperty("language")
    private Language__1 language;
    @JsonProperty("name")
    private String name;

    @JsonProperty("language")
    public Language__1 getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language__1 language) {
        this.language = language;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
