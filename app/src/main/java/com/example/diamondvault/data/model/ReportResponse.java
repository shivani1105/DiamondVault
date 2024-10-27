package com.example.diamondvault.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ReportResponse {

    @SerializedName("quarterly_revenue")
    private List<QuarterlyRevenue> quarterlyRevenue;
    @SerializedName("total_sale")
    private double totalSale;

    public List<QuarterlyRevenue> getQuarterlyRevenue() {
        return quarterlyRevenue;
    }

    public void setQuarterlyRevenue(List<QuarterlyRevenue> quarterlyRevenue) {
        this.quarterlyRevenue = quarterlyRevenue;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }
}
