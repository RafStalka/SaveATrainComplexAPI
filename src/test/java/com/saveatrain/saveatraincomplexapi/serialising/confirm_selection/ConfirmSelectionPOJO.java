
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmSelectionPOJO {

    @JsonProperty("select_results_attributes")
    private SelectResultsAttributes selectResultsAttributes;

    public ConfirmSelectionPOJO(SelectResultsAttributes selectResultsAttributes) {
        this.selectResultsAttributes = selectResultsAttributes;
    }

    public SelectResultsAttributes getSelectResultsAttributes() {
        return selectResultsAttributes;
    }

    public void setSelectResultsAttributes(SelectResultsAttributes selectResultsAttributes) {
        this.selectResultsAttributes = selectResultsAttributes;
    }

}
