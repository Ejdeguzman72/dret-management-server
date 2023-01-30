package com.deguzman.dto;

import java.sql.Date;
import java.time.LocalDate;

public class RevenueDTO {
    private int revenueId;
    private double amount;
    private LocalDate settmentlentDate;
    private String descr;

    public RevenueDTO(int revenueId, double amount, LocalDate settlementDate, String descr) {
    }

    public int getRevenueId() {
        return revenueId;
    }

    public void setRevenueId(int revenueId) {
        this.revenueId = revenueId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getSettmentlentDate() {
        return settmentlentDate;
    }

    public void setSettmentlentDate(LocalDate settmentlentDate) {
        this.settmentlentDate = settmentlentDate;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
