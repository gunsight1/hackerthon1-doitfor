package com.kernel360.doitforme.util;

public class Utils {
    public static final String domain = "http://localhost:8080/";
    public static String encode(String originUrl) {
        // 알고리즘을 사용하여 수정 필요

        return domain + "kernel360";
    }

    public static String cutOriginUrl(String originUrl) {
        return originUrl.replaceAll("http://localhost:8080/", "");
    }

    public static String pasteOriginUrl(String originUrl) {
        return domain + originUrl;
    }
}
