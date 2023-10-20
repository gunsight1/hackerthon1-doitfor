package com.kernel360.doitforme.service;

import com.kernel360.doitforme.dto.UrlRequest;
import com.kernel360.doitforme.dto.UrlResponse;
import com.kernel360.doitforme.entity.Url;
import com.kernel360.doitforme.repository.UrlRepository;
import com.kernel360.doitforme.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional()
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlResponse shortUrl(final UrlRequest urlRequest) throws Exception {
        // 초기 재귀 호출 상태, recursionCount를 0으로 설정
        return shortUrl(urlRequest, 0);
    }

    private UrlResponse shortUrl(final UrlRequest urlRequest, int recursionCount) throws Exception {
        if (recursionCount >= 3) {
            // 재귀 호출이 3번 이상 발생한 경우 예외 던지기
            throw new Exception("재귀 호출 제한 초과");
        }
        String convertUrl = Utils.encode(urlRequest.getOriginUrl());

        try {
            // 중복된 convertUrl이 발생할 수 있음
            Url savedUrl = urlRepository.save(UrlRequest.toEntity(urlRequest, convertUrl));
            return UrlResponse.of(savedUrl);
        } catch (DataIntegrityViolationException ex) {
            // 중복된 convertUrl이 발생한 경우, 재귀 호출 횟수를 증가시키고 다시 시도
            return shortUrl(urlRequest, recursionCount + 1);
        }
    }

    public String findOriginUrl(final String convertUrl) {
        Url findUrl = urlRepository.findByConvertUrl(convertUrl)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 url"));

        return findUrl.getOriginUrl();
    }
}
