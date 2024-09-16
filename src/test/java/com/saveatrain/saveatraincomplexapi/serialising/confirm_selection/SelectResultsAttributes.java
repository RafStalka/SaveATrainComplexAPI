
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectResultsAttributes {

    private String search_identifier;
    private int result_id;
    private Map<String, TransferData> transfers_attributes;

    public SelectResultsAttributes(String searchIdentifier, int resultId, TransferData transferData) {
        this.search_identifier = searchIdentifier;
        this.result_id = resultId;
        this.transfers_attributes = new HashMap<>();
        this.transfers_attributes.put("0", transferData); // Ustawienie klucza "0"
    }

    public String getSearch_identifier() {
        return search_identifier;
    }

    public void setSearch_identifier(String search_identifier) {
        this.search_identifier = search_identifier;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public Map<String, TransferData> getTransfers_attributes() {
        return transfers_attributes;
    }

    public void setTransfers_attributes(Map<String, TransferData> transfers_attributes) {
        this.transfers_attributes = transfers_attributes;
    }
}
