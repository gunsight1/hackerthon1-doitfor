package com.kernel360.doitforme.dto;

import com.kernel360.doitforme.entity.Url;
import com.kernel360.doitforme.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UrlRequest {
    private String originUrl;
    private String convertUrl;

    public static Url toEntity(UrlRequest urlRequest, String convertUrl) {
        return Url.builder()
                .originUrl(urlRequest.originUrl)
                .convertUrl(Utils.cutOriginUrl(convertUrl))
                .build();
    }

}
