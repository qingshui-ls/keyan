package com.vuetutorial.utils;

import org.springframework.util.DigestUtils;

public class PasswordEncoder {
    private static final String SALT = "kjfcsddkjfdsajfdiusf8743urf";

    public static String encodePassword(String rawPassword) {
        String encodedPassword = DigestUtils.md5DigestAsHex(
                (SALT + SALT + rawPassword + SALT + SALT).getBytes());
        return encodedPassword;
    }
}
