
package com.saveatrain.saveatraincomplexapi.serialising.confirm_selection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferData {


    private static final String TRANSFER_ATTRIBUTE_KEY = "0";

    @JsonProperty(TRANSFER_ATTRIBUTE_KEY)
    private TransferData transferData;

    @JsonProperty(TRANSFER_ATTRIBUTE_KEY)
    public TransferData getTransferData() {
        return transferData;
    }

    @JsonProperty(TRANSFER_ATTRIBUTE_KEY)
    public void setTransferData(TransferData transferData) {
        this.transferData = transferData;
    }

}
