package com.example.demo.scenario2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Advanced data processing utility class.
 * Perfect for demonstrating Copilot Chat's project README generation capabilities.
 * 
 * This complex codebase with multiple scenarios provides rich context for:
 * - Analyzing project structure and generating comprehensive README
 * - Creating professional project documentation
 * - Writing user-facing project guides
 * - Generating installation and usage instructions
 */
public class DataProcessor {
    
    private final Map<String, Double> conversionRates;
    
    public DataProcessor() {
        this.conversionRates = new HashMap<>();
        initializeConversionRates();
    }
    
    private void initializeConversionRates() {
        conversionRates.put("USD_EUR", 0.85);
        conversionRates.put("USD_GBP", 0.73);
        conversionRates.put("EUR_GBP", 0.86);
        conversionRates.put("GBP_USD", 1.37);
        conversionRates.put("EUR_USD", 1.18);
        conversionRates.put("GBP_EUR", 1.16);
    }
    
    // Complex algorithm that needs good documentation
    public List<TransactionSummary> processTransactions(List<Transaction> transactions, 
                                                       String targetCurrency) {
        return transactions.stream()
            .filter(transaction -> transaction.getAmount() > 0)
            .map(transaction -> convertTransaction(transaction, targetCurrency))
            .collect(Collectors.groupingBy(
                Transaction::getCategory,
                Collectors.summingDouble(Transaction::getAmount)
            ))
            .entrySet()
            .stream()
            .map(entry -> new TransactionSummary(
                entry.getKey(),
                entry.getValue(),
                targetCurrency,
                calculateTaxRate(entry.getKey())
            ))
            .sorted((s1, s2) -> Double.compare(s2.getTotalAmount(), s1.getTotalAmount()))
            .collect(Collectors.toList());
    }
    
    private Transaction convertTransaction(Transaction transaction, String targetCurrency) {
        if (transaction.getCurrency().equals(targetCurrency)) {
            return transaction;
        }
        
        String conversionKey = transaction.getCurrency() + "_" + targetCurrency;
        Double rate = conversionRates.get(conversionKey);
        
        if (rate == null) {
            throw new IllegalArgumentException("Conversion rate not found: " + conversionKey);
        }
        
        double convertedAmount = transaction.getAmount() * rate;
        return new Transaction(
            transaction.getId(),
            transaction.getCategory(),
            convertedAmount,
            targetCurrency,
            transaction.getTimestamp()
        );
    }
    
    private double calculateTaxRate(String category) {
        switch (category.toLowerCase()) {
            case "food": return 0.05;
            case "electronics": return 0.15;
            case "clothing": return 0.10;
            case "services": return 0.18;
            default: return 0.12;
        }
    }
    
    // Performance-critical method with complex logic
    public Map<String, Double> calculateMovingAverages(List<Double> values, int windowSize) {
        Map<String, Double> results = new HashMap<>();
        
        if (values.size() < windowSize) {
            results.put("error", -1.0);
            return results;
        }
        
        double sum = values.subList(0, windowSize).stream().mapToDouble(Double::doubleValue).sum();
        results.put("first_average", sum / windowSize);
        
        double maxAverage = sum / windowSize;
        double minAverage = sum / windowSize;
        
        for (int i = windowSize; i < values.size(); i++) {
            sum = sum - values.get(i - windowSize) + values.get(i);
            double currentAverage = sum / windowSize;
            
            maxAverage = Math.max(maxAverage, currentAverage);
            minAverage = Math.min(minAverage, currentAverage);
        }
        
        results.put("final_average", sum / windowSize);
        results.put("max_average", maxAverage);
        results.put("min_average", minAverage);
        results.put("volatility", maxAverage - minAverage);
        
        return results;
    }
}
