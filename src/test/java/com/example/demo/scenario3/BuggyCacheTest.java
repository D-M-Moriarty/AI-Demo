package com.example.demo.scenario3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that reveals bugs in the BuggyCache implementation.
 * Great for asking Copilot: "These tests are failing, help me debug the cache"
 */
class BuggyCacheTest {

    @Test
    @DisplayName("Cache should respect TTL")
    void testTTLExpiration() throws InterruptedException {
        BuggyCache<String, String> cache = new BuggyCache<>(10, 100); // 100ms TTL
        
        cache.put("key1", "value1");
        assertEquals("value1", cache.get("key1"));
        
        Thread.sleep(150); // Wait longer than TTL
        
        // This should return null, but might not due to timing issues
        assertNull(cache.get("key1"));
    }
    
    @Test
    @DisplayName("Cache should enforce size limits")
    void testSizeLimit() {
        BuggyCache<String, String> cache = new BuggyCache<>(3, 10000); // 3 item limit
        
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.put("key4", "value4"); // This should trigger eviction
        cache.put("key5", "value5"); // This should trigger eviction
        
        // The cache should not exceed the size limit
        // But this test might fail because size limit isn't enforced
        assertTrue(cache.size() <= 3, "Cache size should not exceed limit");
    }
    
    @Test
    @DisplayName("Concurrent access should be safe")
    void testConcurrentAccess() throws InterruptedException {
        BuggyCache<String, String> cache = new BuggyCache<>(100, 5000);
        
        // This test might reveal race conditions
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cache.put("key" + i, "value" + i);
            }
        });
        
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cache.get("key" + (i % 100));
            }
        });
        
        Thread evictor = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                cache.evictExpired();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        writer.start();
        reader.start();
        evictor.start();
        
        writer.join();
        reader.join();
        evictor.join();
        
        // If we get here without exceptions, that's good
        // But the cache might still have consistency issues
        assertTrue(cache.size() >= 0);
    }
    
    // TODO: Ask Copilot to help identify what's wrong with these failing tests
    // and suggest fixes for the underlying cache implementation
}
