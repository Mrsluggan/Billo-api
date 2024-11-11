package com.idata.eboks.models;

import java.time.LocalDate;

public class PaymentClass {
    private boolean payable;
    private String currency;
    private LocalDate dueDate;
    private String totalOwed;
    private String type;
    private String method;
    private String account;
    private String reference;
    private Boolean variableAmount;
    private String minAmount;

    public boolean getPayable() {
        return payable;
    }

    public void setPayable(boolean value) {
        this.payable = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String value) {
        this.currency = value;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate value) {
        this.dueDate = value;
    }

    public String getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(String value) {
        this.totalOwed = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String value) {
        this.method = value;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String value) {
        this.account = value;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String value) {
        this.reference = value;
    }

    public Boolean getVariableAmount() {
        return variableAmount;
    }

    public void setVariableAmount(Boolean value) {
        this.variableAmount = value;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String value) {
        this.minAmount = value;
    }
}
