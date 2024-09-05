
package com.saveatrain.saveatraincomplexapi.deserialising.outbound_subroutes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transfer {

    public Transfer(Integer id, List<Change> changes, List<Fare> fares) {
        this.id = id;
        this.changes = changes;
        this.fares = fares;
    }

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("changes")
    private List<Change> changes;
    @JsonProperty("fares")
    private List<Fare> fares;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("changes")
    public List<Change> getChanges() {
        return changes;
    }

    @JsonProperty("changes")
    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

    @JsonProperty("fares")
    public List<Fare> getFares() {
        return fares;
    }

    @JsonProperty("fares")
    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

}
