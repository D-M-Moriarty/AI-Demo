package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation for loading XML data.
 * Handles XML-specific parsing with namespace handling.
 */
public class XmlDataLoader implements DataLoader {
    
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading XML data from legacy system");
        
        // XML parsing with namespace handling
        Map<String, Object> xmlData = new HashMap<>();
        xmlData.put("type", "xml");
        xmlData.put("schema", "legacy");
        xmlData.put("namespaces", "handled");
        
        return xmlData;
    }
    
    @Override
    public String getDataType() {
        return "xml";
    }
}
