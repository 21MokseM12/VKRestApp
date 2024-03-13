package org.app.Controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TokenGenerator {
    public static String generateToken(String login, String password) {
        String data = login + ":" + password;
        String base64Data = Base64.getEncoder().encodeToString(data.getBytes());
        return base64Data;
    }
}

