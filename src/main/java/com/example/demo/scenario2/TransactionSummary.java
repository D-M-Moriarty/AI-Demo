package com.example.demo.scenario2;

public class TransactionSummary {
    private final String category;
    private final double totalAmount;
    private final String currency;
    private final double taxRate;
    
    public TransactionSummary(String category, double totalAmount, String currency, double taxRate) {
        this.category = category;
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.taxRate = taxRate;
    }
    
    public String getCategory() { return category; }
    public double getTotalAmount() { return totalAmount; }
    public String getCurrency() { return currency; }
    public double getTaxRate() { return taxRate; }
    
    public double getTotalWithTax() {
        return totalAmount * (1 + taxRate);
    }
}
