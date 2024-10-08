package com.saveatrain.utils;

import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = GetPropertyValues.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (Exception ex) {
            throw new RuntimeException("Error loading properties file", ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
