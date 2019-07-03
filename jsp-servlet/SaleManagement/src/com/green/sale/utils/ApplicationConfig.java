package com.green.sale.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {
    private static Properties prop = new Properties();

    static {
        try (InputStream input = ApplicationConfig.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            } else {
                // load a properties file from class path, inside static method
                prop.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getConfig(String key) {
        return getConfig(key, null);
    }

    public static String getConfig(String key, String defaultVal) {
        return prop.getProperty(key, defaultVal);
    }
}
