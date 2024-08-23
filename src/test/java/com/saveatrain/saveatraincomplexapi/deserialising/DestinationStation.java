
package com.saveatrain.saveatraincomplexapi.deserialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DestinationStation {

    public DestinationStation() {

    }

    public DestinationStation(String uid, List<Name__1> names) {
        this.uid = uid;
        this.names = names;
    }

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("names")
    private List<Name__1> names;

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("names")
    public List<Name__1> getNames() {
        return names;
    }

    @JsonProperty("names")
    public void setNames(List<Name__1> names) {
        this.names = names;
    }

}
