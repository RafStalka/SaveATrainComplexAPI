
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmSelectionPOJO {

    @JsonProperty("select_results_attributes")
    private SelectResultsAttributes select_results_attributes;

    public ConfirmSelectionPOJO(SelectResultsAttributes selectResultsAttributes) {
        this.select_results_attributes = selectResultsAttributes;
    }

    public SelectResultsAttributes getSelect_results_attributes() {
        return select_results_attributes;
    }

    public void setSelect_results_attributes(SelectResultsAttributes select_results_attributes) {
        this.select_results_attributes = select_results_attributes;
    }
}
