package com.idata.eboks.configs.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ErrorDto {
    private String message;

}