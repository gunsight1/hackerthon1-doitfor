package com.kernel360.doitforme.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    private Utils(){

    }
    public static final String domain = "http://localhost:8080/";
    public static String encode(String originUrl) {

        // originUrl 을 encoding 과정을 거쳐 7글자내의 영어대소문자와 숫자의 조합으로
        // 문자열을 만들어 domain과 결합해 리턴

        try {
            MessageDigest md5 ;
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {

                throw new RuntimeException(e);
            }

            byte[] bytes = originUrl.getBytes(StandardCharsets.UTF_8);
            md5.update(bytes);
            byte[] digest = md5.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Character.forDigit((b & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(b & 0x0f, 16));
            }
            return domain + sb.substring(0, 7);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String cutOriginUrl(String originUrl) {
        return originUrl.replace(domain, "");
    }

    public static String pasteOriginUrl(String originUrl) {
        return domain + originUrl;
    }
}