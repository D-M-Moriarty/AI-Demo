package com.example.demo.godclassrefactoring.refactored;

/**
 * Strategy Pattern for Data Processing
 * Each processing type has its own implementation
 */
public interface ProcessingStrategy {
    Object process(Object data);
}
