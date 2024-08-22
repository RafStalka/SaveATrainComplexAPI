package com.saveatrain.saveatraincomplexapi.serialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchPOJO {

    public SearchPOJO() {
    }

    public SearchPOJO(Search search) {
        this.search = search;
    }

    @JsonProperty("search")
    private Search search;

    @JsonProperty("search")
    public Search getSearch() {
        return search;
    }

    @JsonProperty("search")
    public void setSearch(Search search) {
        this.search = search;
    }

}
