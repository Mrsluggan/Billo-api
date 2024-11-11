package com.idata.eboks.models;

import java.util.List;

import lombok.Data;


@Data
public class GetTenantRequest {
    private List<String> vatNumbers;

}
