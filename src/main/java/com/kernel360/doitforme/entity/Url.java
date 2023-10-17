package com.kernel360.doitforme.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "url")
public class Url extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "origin_url", columnDefinition = "varchar(255)")
    private String originUrl;
    @Column(name = "convert_url", columnDefinition = "varchar(255)")
    private String convertUrl;

    @Builder
    public Url(Long id, String originUrl, String convertUrl) {
        this.id = id;
        this.originUrl = originUrl;
        this.convertUrl = convertUrl;
    }
}
