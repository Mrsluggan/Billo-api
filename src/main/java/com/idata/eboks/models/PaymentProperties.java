package com.idata.eboks.models;

public class PaymentProperties {
    private ContentType payable;
    private Account currency;
    private NameClass dueDate;
    private Account totalOwed;
    private Account type;
    private Account method;
    private Account account;
    private Account reference;
    private MinAmount minAmount;

    public ContentType getPayable() {
        return payable;
    }

    public void setPayable(ContentType value) {
        this.payable = value;
    }

    public Account getCurrency() {
        return currency;
    }

    public void setCurrency(Account value) {
        this.currency = value;
    }

    public NameClass getDueDate() {
        return dueDate;
    }

    public void setDueDate(NameClass value) {
        this.dueDate = value;
    }

    public Account getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(Account value) {
        this.totalOwed = value;
    }

    public Account getType() {
        return type;
    }

    public void setType(Account value) {
        this.type = value;
    }

    public Account getMethod() {
        return method;
    }

    public void setMethod(Account value) {
        this.method = value;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account value) {
        this.account = value;
    }

    public Account getReference() {
        return reference;
    }

    public void setReference(Account value) {
        this.reference = value;
    }

    public MinAmount getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(MinAmount value) {
        this.minAmount = value;
    }
}