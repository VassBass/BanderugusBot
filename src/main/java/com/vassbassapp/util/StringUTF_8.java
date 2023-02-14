package com.vassbassapp.util;

import java.nio.charset.StandardCharsets;

public class StringUTF_8 {
    private StringUTF_8(){}

    public static String get(String source) {
        return new String(source.getBytes(), StandardCharsets.UTF_8);
    }
}
