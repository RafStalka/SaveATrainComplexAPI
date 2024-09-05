
package com.saveatrain.saveatraincomplexapi.deserialising.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name__2 {

    public Name__2() {

    }

    public Name__2(Language__2 language, String name) {
        this.language = language;
        this.name = name;
    }

    @JsonProperty("language")
    private Language__2 language;
    @JsonProperty("name")
    private String name;

    @JsonProperty("language")
    public Language__2 getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language__2 language) {
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
