package com.monkilatech.backendcampasilano.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class StatusResponse<T> {
    
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;
    
}
