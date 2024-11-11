package com.idata.eboks.models;

import lombok.Data;

@Data
public class Payment {
    private boolean payable; // Required
    private String currency; // Required
    private String dueDate; // Required
    private String totalOwed; // Required
    private String type; // Required
    private String method; // Required
    private String account; // Required
    private String reference; // Required
    private String minAmount;
}
