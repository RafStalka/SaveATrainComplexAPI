
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectResultsAttributes {

    private static final String SEARCH_IDENTIFIER = "search_identifier";
    private static final String RESULT_ID = "result_id";
    private static final String TRANSFERS_ATTRIBUTES = "transfers_attributes";

    @JsonProperty(SEARCH_IDENTIFIER)
    private String searchIdentifier;
    @JsonProperty(RESULT_ID)
    private Integer resultId;
    @JsonProperty(TRANSFERS_ATTRIBUTES)
    private TransferData transferData;

    public SelectResultsAttributes(String searchIdentifier, Integer resultId, TransferData transferData) {
        this.searchIdentifier = searchIdentifier;
        this.resultId = resultId;
        this.transferData = transferData;
    }

    @JsonProperty(SEARCH_IDENTIFIER)
    public String getSearchIdentifier() {
        return searchIdentifier;
    }

    @JsonProperty(SEARCH_IDENTIFIER)
    public void setSearchIdentifier(String searchIdentifier) {
        this.searchIdentifier = searchIdentifier;
    }

    @JsonProperty(RESULT_ID)
    public Integer getResultId() {
        return resultId;
    }

    @JsonProperty(RESULT_ID)
    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    @JsonProperty(TRANSFERS_ATTRIBUTES)
    public TransferData getTransfersAttributes() {
        return transferData;
    }

    @JsonProperty(TRANSFERS_ATTRIBUTES)
    public void setTransfersAttributes(TransferData transferData) {
        this.transferData = transferData;
    }

}
