package com.example.demo.godclassrefactoring.solutions.run1;

public class DataHandlerFactory {

    public static DataLoader createDataLoader(String dataType) {
        switch (dataType.toLowerCase()) {
            case "csv":
                return new CsvDataLoader();
            case "json":
                return new JsonDataLoader();
            case "xml":
                return new XmlDataLoader();
            case "database":
                return new DatabaseDataLoader();
            default:
                throw new IllegalArgumentException("Unsupported data type: " + dataType);
        }
    }

    public static DataProcessor createDataProcessor(String processingType) {
        switch (processingType.toLowerCase()) {
            case "validate":
                return new ValidateProcessor();
            case "transform":
                return new TransformProcessor();
            default:
                throw new IllegalArgumentException("Unsupported processing type: " + processingType);
        }
    }

    public static DataSaver createDataSaver(String saveType) {
        switch (saveType.toLowerCase()) {
            case "database":
                return new DatabaseSaver();
            case "filesystem":
                return new FileSystemSaver();
            default:
                throw new IllegalArgumentException("Unsupported save type: " + saveType);
        }
    }
}

