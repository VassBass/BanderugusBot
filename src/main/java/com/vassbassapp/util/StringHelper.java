package com.vassbassapp.util;

import java.nio.charset.StandardCharsets;

public class StringHelper {
    private StringHelper(){}

    public static String getUTF_8(String source) {
        return new String(source.getBytes(), StandardCharsets.UTF_8);
    }
}
