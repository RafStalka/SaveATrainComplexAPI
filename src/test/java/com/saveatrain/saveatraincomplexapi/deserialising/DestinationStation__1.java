
package com.saveatrain.saveatraincomplexapi.deserialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DestinationStation__1 {

    public DestinationStation__1() {

    }

    public DestinationStation__1(String uid, List<Name__3> names) {
        this.uid = uid;
        this.names = names;
    }

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("names")
    private List<Name__3> names;

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("names")
    public List<Name__3> getNames() {
        return names;
    }

    @JsonProperty("names")
    public void setNames(List<Name__3> names) {
        this.names = names;
    }

}
