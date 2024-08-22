package com.saveatrain.saveatraincomplexapi.serialising;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchesPassengersAttributes {

    public SearchesPassengersAttributes() {
    }

    public SearchesPassengersAttributes(com.saveatrain.saveatraincomplexapi.serialising._0 _0) {
        this._0 = _0;
    }

    @JsonProperty("0")
    private _0 _0;

    @JsonProperty("0")
    public _0 get0() {
        return _0;
    }

    @JsonProperty("0")
    public void set0(_0 _0) {
        this._0 = _0;
    }

}
