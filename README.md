![Untitled](https://github.com/Kernel360/hackerthon1-doitfor/assets/103917282/3ba325ba-2c80-4220-a173-cebc879a7e78)



# 프로젝트 개요

이 프로젝트는 Spring Boot를 사용하여 개발된 웹 애플리케이션입니다. 이 애플리케이션은 다음과 같은 주요 특징을 갖고 있습니다:

- **Spring Boot 2.7.16**: Spring Boot의 최신 버전을 사용하여 개발되었습니다.
- **Spring Data JPA**: 데이터베이스 액세스 및 관리를 위한 Spring Data JPA를 사용합니다.
- **Thymeleaf**: Thymeleaf 템플릿 엔진을 사용하여 웹 페이지를 동적으로 생성합니다.
- **Lombok**: Lombok을 사용하여 코드를 간결하게 작성합니다.
- **MySQL Connector**: MySQL 데이터베이스와의 연결을 위해 MySQL Connector를 사용합니다.

## hackerthon1-doitfor
shortURL을 만들어주는 서비스입니다.

이 Java Spring Boot 애플리케이션인 "Doitforme"은 URL 단축 서비스를 제공합니다. 사용자는 긴 URL을 짧게 변환하고 변환된 URL을 사용하여 쉽게 원본 URL에 액세스할 수 있습니다. 이 애플리케이션은 다음과 같이 구성되어 있습니다.

- **컨트롤러**: `UrlController` 클래스는 URL 경로 설정 및 사용자 인터페이스와 상호 작용을 담당합니다.

- **DTO (데이터 전송 객체)**: 애플리케이션은 데이터를 프런트엔드와 백엔드 간에 전송하기 위해 `UrlRequest` 및 `UrlResponse`와 같은 DTO를 사용합니다.

- **엔티티**: `Url` 엔티티는 URL 레코드를 나타내며 원본 및 변환된 URL에 대한 정보를 저장합니다.

- **리포지토리**: `UrlRepository`는 엔티티의 데이터 저장 및 검색에 대한 데이터베이스 상호 작용 및 CRUD 작업을 처리합니다.

- **서비스**: `UrlService` 클래스에는 URL 단축에 대한 핵심 비즈니스 로직이 포함되어 있으며 데이터 저장 및 검색을 위해 리포지토리와 상호 작용합니다.

- **Audit**: 애플리케이션은 엔티티의 생성 및 수정 타임스탬프를 자동으로 캡처 및 관리하기 위해 JPA Audit을 활용합니다.

## 사용법

- 주 메인 페이지를 확인하려면 루트 URL (예: `http://localhost:8080/`)에 액세스합니다.
- 제공된 입력 필드에 긴 URL을 입력하고 "단축" 버튼을 클릭하여 단축 URL로 변환합니다.
- 단축 URL이 표시된 페이지로 리디렉션됩니다.
- 단축 URL에 액세스하면 원본 URL로 리디렉션됩니다.

## 애플리케이션 구성요소

### UrlController

- `GET /`: 주 메인 페이지를 표시합니다.
- `GET /result`: 쿼리 매개변수로 변환된 URL이 포함된 주 메인 페이지를 표시합니다.
- `POST /api/v1/shoutUrl`: 긴 URL을 단축 URL로 변환하고 `/result` 페이지로 리디렉션합니다.
- `GET /{convertUrl}`: 변환된 URL을 기반으로 원본 URL로 리디렉션합니다.

### DTOs

- `UrlRequest`: URL 단축 요청의 데이터를 나타냅니다. 원본 및 변환된 URL이 포함됩니다.
- `UrlResponse`: URL 단축 응답의 데이터를 나타냅니다. 변환된 URL이 포함됩니다.

### 엔티티

- `Url`: 원본 URL, 변환된 URL 및 감사 타임스탬프에 대한 필드를 포함하는 URL 엔티티를 나타냅니다.

### 리포지토리

- `UrlRepository`: `Url` 엔티티의 데이터 액세스 메서드를 제공하며 변환된 URL을 기반으로 URL 레코드를 찾는 메서드를 포함합니다.

### 서비스

- `UrlService`: URL 단축을 위한 핵심 비즈니스 로직을 포함하며 단축 URL을 생성하고 원본 URL을 검색합니다.

## 애플리케이션 실행

1. 시스템에 Java와 Gradle이 설치되어 있는지 확인합니다.
2. 저장소에서 프로젝트를 복제합니다.
3. Gradle을 사용하여 프로젝트를 빌드합니다
4. 애플리케이션을 실행합니다

애플리케이션은 `http://localhost:8080/`에서 실행됩니다.

## 데이터베이스 구성

이 애플리케이션은 데이터 저장을 위해 MySQL 데이터베이스와 Spring Data JPA를 사용합니다. 데이터베이스 설정을 `application.yml` 파일에서 구성할 수 있습니다.

## 참고

이 README는 "Doitforme" URL 단축 애플리케이션의 개요를 제공합니다. 필요에 따라 자세한 문서 및 사용 지침을 제공할 수 있습니다.
