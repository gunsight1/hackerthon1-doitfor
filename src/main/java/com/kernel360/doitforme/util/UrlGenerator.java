package com.kernel360.doitforme.util;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;


public class UrlGenerator {

    public static String generateUniqueId (String originUrl) {

        Instant now = Instant.now();
        UUID uuid = UUID.randomUUID();
        long mostSignBits = uuid.getMostSignificantBits();

        String uniqueID = uuid.toString().replace("-", "");
        uniqueID += String.valueOf(now.toEpochMilli()).substring(10);

        byte[] sha256Hash = sha256(uniqueID.getBytes(StandardCharsets.UTF_8));

        String uniqueId = bytesToHex(sha256Hash);

        return uniqueId.substring(0,7);
    }

    public static String encodingUri (String originUrl) {

        String uri = generateUniqueId(originUrl);

        return uri;
    }

    public static byte[] sha256(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
