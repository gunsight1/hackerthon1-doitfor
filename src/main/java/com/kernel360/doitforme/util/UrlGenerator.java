package com.kernel360.doitforme.util;
import org.springframework.beans.factory.annotation.Value;

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

        byte[] encodedBytes = Base64.getUrlEncoder().encode(getBytesFromLong(mostSignBits));
        String uniqueId = new String(encodedBytes);

        return uniqueId.substring(0,7);
    }

    public static String encodingUri (String originUrl) {
        String uri = generateUniqueId(originUrl);
        return uri;
    }

    public static byte[] getBytesFromLong(long value) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (value & 0xFF);
            value >>= 8;
        }
        return result;
    }
}
