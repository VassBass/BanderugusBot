package com.vassbassapp.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAPIConfigHolderTest {
    private static final String TEST_PROPERTIES_FILE = "api_test.properties";
    private DefaultAPIConfigHolder configHolder;

    @BeforeEach
    public void init() {
        configHolder = new DefaultAPIConfigHolder(TEST_PROPERTIES_FILE);
    }

    @Test
    void getUserName() {
        final String expected = "TestBot";
        final String actual = configHolder.getUserName();
        assertEquals(expected, actual);
    }

    @Test
    void getApiToken() {
        final String expected = "TestToken";
        final String actual = configHolder.getApiToken();
        assertEquals(expected, actual);
    }
}