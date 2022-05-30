# spring-cloud

인프런 강의 소스 저장소
> - [Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/dashboard)
>
> - 참고
https://wonit.tistory.com/489

---



## 1. DiscoveryService

- Service discovery - Spring Cloud Netflix Eureka
- 외부에서 다른 서비스를 검색하기 위하여 사용되는 개념 (feat. 전화번호부 책)
- MSA 에서 어떠한 서버(서비스)가 어디에 위치했는지 등록 및 관리
- 검색에 관련된게 Discovery Service 라고 함.
- Spring Cloud Netflix Eureka 가 그 역할을 함.



## 2. UserService

- DiscoveryService 에 등록 예제



## 3. FirstApiService / SecondApiService

- Test Api Server



## 4. ApiGatewayService

- Test Api Server 를 이걸 통해서 연결
