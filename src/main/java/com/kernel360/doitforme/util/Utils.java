package com.kernel360.doitforme.util;

public class Utils {
    public static final String domain = "http://localhost:8080/";

    private static UrlGenerator urlGenerator;

    public static String encode(String originUrl) throws Exception {
        String convertUrl = urlGenerator.encodingUri(originUrl);
        return domain + convertUrl;
    }

    public static String cutOriginUrl(String originUrl) {
        return originUrl.replaceAll(domain, "");
    }

    public static String pasteOriginUrl(String originUrl) {
        return domain + originUrl;
    }
}
