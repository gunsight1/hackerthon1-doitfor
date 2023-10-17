package com.kernel360.doitforme.service;

import com.kernel360.doitforme.dto.UrlRequest;
import com.kernel360.doitforme.dto.UrlResponse;
import com.kernel360.doitforme.entity.Url;
import com.kernel360.doitforme.repository.UrlRepository;
import com.kernel360.doitforme.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    @Transactional
    public UrlResponse shortUrl(final UrlRequest urlRequest) {
        // 알고리즘을 통해 convertUrl을 생성한다.
        String convertUrl = Utils.encode(urlRequest.getOriginUrl());
        Url savedUrl = urlRepository.save(UrlRequest.toEntity(urlRequest, convertUrl));

        return UrlResponse.of(savedUrl);
    }

    public String findOriginUrl(final String convertUrl) {
        Url findUrl = urlRepository.findByConvertUrl(convertUrl)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 url"));

        return findUrl.getOriginUrl();
    }
}
