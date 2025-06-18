package com.example.demo.scenario3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache implementation with potential issues.
 * Perfect for demonstrating Copilot Chat's debugging capabilities.
 * 
 * Ask Copilot to:
 * - "Help me find the bug in this cache implementation"
 * - "Why might this code cause memory leaks?"
 * - "What threading issues could occur here?"
 * - "How can I improve the performance?"
 */
public class BuggyCache<K, V> {
    
    private final Map<K, CacheEntry<V>> cache;
    private final int maxSize;
    private final long ttlMillis;
    
    public BuggyCache(int maxSize, long ttlMillis) {
        this.cache = new ConcurrentHashMap<>();
        this.maxSize = maxSize;
        this.ttlMillis = ttlMillis;
    }
    
    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        
        if (entry == null) {
            return null;
        }
        
        // BUG: This check has an issue with timing
        if (System.currentTimeMillis() - entry.getCreatedTime() > ttlMillis) {
            cache.remove(key);
            return null;
        }
        
        return entry.getValue();
    }
    
    public void put(K key, V value) {
        // BUG: No size limit enforcement - memory leak potential
        // BUG: No cleanup of expired entries
        CacheEntry<V> entry = new CacheEntry<>(value, System.currentTimeMillis());
        cache.put(key, entry);
    }
    
    // BUG: This method has race conditions
    public void evictExpired() {
        long currentTime = System.currentTimeMillis();
        
        // Creating a new list to avoid ConcurrentModificationException
        // but this approach has other issues...
        List<K> expiredKeys = new ArrayList<>();
        
        for (Map.Entry<K, CacheEntry<V>> entry : cache.entrySet()) {
            if (currentTime - entry.getValue().getCreatedTime() > ttlMillis) {
                expiredKeys.add(entry.getKey());
            }
        }
        
        // BUG: Between checking and removing, entries might be accessed
        for (K key : expiredKeys) {
            cache.remove(key);
        }
    }
    
    // BUG: Not thread-safe size checking
    public boolean isFull() {
        return cache.size() >= maxSize;
    }
    
    public int size() {
        return cache.size();
    }
    
    // Performance issue: O(n) operation called frequently
    public void enforceSizeLimit() {
        while (cache.size() > maxSize) {
            // BUG: Removing arbitrary first element, not LRU
            K firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
    }
    
    // Utility method with subtle issue
    public Map<K, V> getAllValid() {
        Map<K, V> result = new HashMap<>();
        long currentTime = System.currentTimeMillis();
        
        for (Map.Entry<K, CacheEntry<V>> entry : cache.entrySet()) {
            // BUG: This creates a race condition with cleanup
            if (currentTime - entry.getValue().getCreatedTime() <= ttlMillis) {
                result.put(entry.getKey(), entry.getValue().getValue());
            }
        }
        
        return result;
    }
    
    private static class CacheEntry<V> {
        private final V value;
        private final long createdTime;
        
        public CacheEntry(V value, long createdTime) {
            this.value = value;
            this.createdTime = createdTime;
        }
        
        public V getValue() { return value; }
        public long getCreatedTime() { return createdTime; }
    }
}
