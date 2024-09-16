
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferData {

    private int id;

    @JsonProperty("fare_id")
    private int fareId;

    public TransferData() {}

    public TransferData(int id, int fareId) {
        this.id = id;
        this.fareId = fareId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFareId() {
        return fareId;
    }

    public void setFareId(int fareId) {
        this.fareId = fareId;
    }

    @Override
    public String toString() {
        return "TransferData{" +
                "id=" + id +
                ", fare_id=" + fareId +
                '}';
    }

}
