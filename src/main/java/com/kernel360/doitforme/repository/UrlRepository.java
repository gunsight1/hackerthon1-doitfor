package com.kernel360.doitforme.repository;

import com.kernel360.doitforme.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByConvertUrl(String convertUrl);
}
