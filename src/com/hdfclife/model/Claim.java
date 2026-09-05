package com.hdfclife.model;

public class Claim {

    private String claimId;
    private int amount;
    private String policyId;
    private String customerName;
    private com.hdfclife.model.Urgency urgency;

    public Claim(String claimId, int amount, String policyId,
                 String customerName, com.hdfclife.model.Urgency urgency) {

        this.claimId = claimId;
        this.amount = amount;
        this.policyId = policyId;
        this.customerName = customerName;
        this.urgency = urgency;
    }

    public String getClaimId() {
        return claimId;
    }

    public int getAmount() {
        return amount;
    }

    public com.hdfclife.model.Urgency getUrgency() {
        return urgency;
    }
}