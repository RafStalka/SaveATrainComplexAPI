
package com.saveatrain.saveatraincomplexapi.deserialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name__3 {

    public Name__3() {

    }

    public Name__3(Language__3 language, String name) {
        this.language = language;
        this.name = name;
    }

    @JsonProperty("language")
    private Language__3 language;
    @JsonProperty("name")
    private String name;

    @JsonProperty("language")
    public Language__3 getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language__3 language) {
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
