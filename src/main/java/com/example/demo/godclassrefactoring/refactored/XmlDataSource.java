package com.example.demo.godclassrefactoring.refactored;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * XML data source implementation
 */
public class XmlDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading XML data from legacy system");
        Map<String, Object> xmlData = new HashMap<>();
        xmlData.put("type", "xml");
        xmlData.put("schema", "legacy");
        return xmlData;
    }
    
    @Override
    public String formatOutput(Object processedData) {
        return "XML Output: " + processedData.toString();
    }
}
