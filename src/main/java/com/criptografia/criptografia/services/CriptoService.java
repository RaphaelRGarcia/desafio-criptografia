package com.criptografia.criptografia.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CriptoService {
    
    public static String encode(String info) throws Exception{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte encoded[] = digest.digest(info.getBytes(StandardCharsets.UTF_8));
        String encodedToken = new String(encoded,StandardCharsets.UTF_8);
        return encodedToken;
    }
}
