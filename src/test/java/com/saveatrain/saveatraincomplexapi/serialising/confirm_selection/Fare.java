
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fare {

    public static final String ID_FIELD = "id";
    public static final String FARE_ID_FIELD = "fare_id";

    @JsonProperty(ID_FIELD)
    private Integer id;

    @JsonProperty(FARE_ID_FIELD)
    private Integer fareId;

    public Fare(final Integer id, final Integer fareId) {
        this.id = id;
        this.fareId = fareId;
    }

    @JsonProperty(ID_FIELD)
    public Integer getId() {
        return id;
    }

    @JsonProperty(ID_FIELD)
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(FARE_ID_FIELD)
    public Integer getFareId() {
        return fareId;
    }

    @JsonProperty(FARE_ID_FIELD)
    public void setFareId(Integer fareId) {
        this.fareId = fareId;
    }
}
