package com.vassbassapp.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultAPIConfigHolder implements APIConfigHolder {
    private static final String PROPERTIES_FILE = "api.properties";

    private static final String KEY_USER_NAME = "botfather.api.user-name";
    private static final String KEY_API_TOKEN = "botfather.api.token";

    private final String userName;
    private final String token;

    public DefaultAPIConfigHolder() {
        this(PROPERTIES_FILE);
    }

    public DefaultAPIConfigHolder(String propertiesFile) {
        try (InputStream in = DefaultAPIConfigHolder.class.getClassLoader()
                .getResourceAsStream(propertiesFile)){
            Properties properties = new Properties();
            properties.load(in);

            userName = properties.getProperty(KEY_USER_NAME, "");
            token = properties.getProperty(KEY_API_TOKEN, "");

            System.out.println("API config was read successful");
        } catch (IOException e) {
            String message = "Error via reading api config file!";
            throw new RuntimeException(message, e);
        }
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getApiToken() {
        return token;
    }
}
