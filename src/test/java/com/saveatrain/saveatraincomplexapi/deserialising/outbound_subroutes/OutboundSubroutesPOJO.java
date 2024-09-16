
package com.saveatrain.saveatraincomplexapi.deserialising.outbound_subroutes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutboundSubroutesPOJO {
    @JsonProperty("result_id")
    private Integer resultId;

    @JsonProperty("search_identifier")
    private String searchIdentifier;

    @JsonProperty("transfers")
    private List<Transfer> transfers;

    // Gettery i settery
    @JsonProperty("result_id")
    public Integer getResultId() {
        return resultId;
    }

    @JsonProperty("result_id")
    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    @JsonProperty("search_identifier")
    public String getSearchIdentifier() {
        return searchIdentifier;
    }

    @JsonProperty("search_identifier")
    public void setSearchIdentifier(String searchIdentifier) {
        this.searchIdentifier = searchIdentifier;
    }

    @JsonProperty("transfers")
    public List<Transfer> getTransfers() {
        return transfers;
    }

    @JsonProperty("transfers")
    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

}
