package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating output formatter instances.
 * Implements the Factory pattern to manage OutputFormatter creation.
 */
public class OutputFormatterFactory {
    
    private static final Map<String, OutputFormatter> formatters = new HashMap<>();
    
    static {
        // Register available output formatters
        registerFormatter(new CsvOutputFormatter());
        registerFormatter(new JsonOutputFormatter());
        registerFormatter(new XmlOutputFormatter());
        registerFormatter(new DatabaseOutputFormatter());
    }
    
    /**
     * Registers a new output formatter.
     * 
     * @param formatter the output formatter to register
     */
    public static void registerFormatter(OutputFormatter formatter) {
        formatters.put(formatter.getFormatType().toLowerCase(), formatter);
    }
    
    /**
     * Creates an output formatter for the specified format type.
     * 
     * @param formatType the type of output format
     * @return the appropriate output formatter
     * @throws IllegalArgumentException if the format type is not supported
     */
    public static OutputFormatter createFormatter(String formatType) {
        OutputFormatter formatter = formatters.get(formatType.toLowerCase());
        if (formatter == null) {
            throw new IllegalArgumentException("Unsupported format type: " + formatType);
        }
        return formatter;
    }
    
    /**
     * Returns all available format types.
     * 
     * @return array of supported format types
     */
    public static String[] getAvailableFormatTypes() {
        return formatters.keySet().toArray(new String[0]);
    }
}
