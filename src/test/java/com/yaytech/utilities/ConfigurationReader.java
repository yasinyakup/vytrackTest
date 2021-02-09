package com.yaytech.utilities;

import java.io.*;
import java.util.Properties;

public class ConfigurationReader {
    private InputStream inputStream;
    private final String FILE_PATH = "configuration.properties";
    private Properties properties;

    public String getValue(String key){
        try {
            inputStream = new FileInputStream(FILE_PATH);
            properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
