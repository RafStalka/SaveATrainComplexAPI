package com.saveatrain.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {

    private final Properties properties = new Properties();

    public GetPropertyValues() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
