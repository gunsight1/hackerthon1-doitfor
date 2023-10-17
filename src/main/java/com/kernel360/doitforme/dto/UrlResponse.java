package com.kernel360.doitforme.dto;

import com.kernel360.doitforme.entity.Url;
import com.kernel360.doitforme.util.Utils;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlResponse {
    private String convertUrl;

    public static UrlResponse of(Url url) {
        return UrlResponse.builder()
                .convertUrl(Utils.pasteOriginUrl(url.getConvertUrl()))
                .build();
    }
}
