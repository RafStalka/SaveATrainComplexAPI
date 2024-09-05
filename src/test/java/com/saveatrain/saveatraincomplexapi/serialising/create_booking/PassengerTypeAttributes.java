
package com.saveatrain.saveatraincomplexapi.serialising.create_booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassengerTypeAttributes {

    public PassengerTypeAttributes(Integer age, String type) {
        this.age = age;
        this.type = type;
    }

    @JsonProperty("age")
    private Integer age;
    @JsonProperty("type")
    private String type;

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
