package com.kernel360.doitforme.util;

import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {

        static InetAddress localhost;

    static {
        try {
            localhost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    static String ipAddress = localhost.getHostAddress();

    public static final String domain = "3.38.245.93:56203/";

    private static UrlGenerator urlGenerator;

    public Utils() throws UnknownHostException {
    }

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
