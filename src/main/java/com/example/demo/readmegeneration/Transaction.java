package com.example.demo.readmegeneration;

import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final String category;
    private final double amount;
    private final String currency;
    private final LocalDateTime timestamp;
    
    public Transaction(String id, String category, double amount, String currency, LocalDateTime timestamp) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
    }
    
    public String getId() { return id; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
