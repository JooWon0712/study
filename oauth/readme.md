# Spring Security OAuth2.0 Study

## 설정에 필요한 것들

### 패키지 및 클래스 설명
>   * **accounts**
>       * Account
>           * 계정 Entity 
>       * AccountRepository
>           * 계정 Entity Repository
>       * AccountService
>           * UserDetailsService 구현
>           * AuthServerConfig, SecurityConfig에서 사용
>   * **config**
>       * AuthServerConfig
>           * Authorization Server 설정
>           * 조금 더 디테일한 공부 필요
>       * ResourceServerConfig
>           * Resource Server 설정
>           * 조금 더 디테일한 공부 필요
>       * SecurityConfig
>           * Web Security 설정
>           * 조금 더 디테일한 공부 필요
>   * **web**
>       * WebController
>           * 웹 컨트롤러 설정

### 기능 테스트 목록
>   * 인증토큰 발급 받기
>       * AuthServerConfigTest.getAuthToken_ok()


## 참고 링크
### Spring Security OAuth2구현
- https://minwan1.github.io/2018/02/24/2018-03-11-Spring-OAuth%EA%B5%AC%ED%98%84/

### 스프링 시큐리티 OAuth 2 라이브 코딩
- https://www.youtube.com/watch?v=NQM1hghpF0Q&t=1921s

### 스프링 시큐리티 OAuth 토큰 받고 갱신하기
- https://www.youtube.com/watch?v=ZEaJsa5dwNY&t=701s
