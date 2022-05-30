# Spring Cloud Gateway

## 용어 설명

> 작업 방법은 `property (application.yml)` 로도 가능하고, `Java Code` 로도 가능함.

### Predicate
 - 요청 정보가 어떤 것인지 판단하는 필터

### Pre filter
 - 어떤 작업이 일어나기 전에 수행하는 사전 필터

### Post Filter
 - 어떠한 처리가 끝난 뒤 수행되는 필터

### Custom Filter
 - 원하는 곳에 개별적으로 적용, 등록해서 사용하는 Filter

### Global Filter
 - 공통적으로 실행될 수 있는 Filter
   - 모든 Filter 들 중에 가장 먼저 시작 되고,
   - 모든 Filter 들 중에 가장 늦게 종료 됨.
 - `application.yml` 에서 `default-filters` 에 설정

```
2022-05-30 16:46:16.681  INFO 8472 --- [  restartedMain] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8000
2022-05-30 16:46:16.683  INFO 8472 --- [  restartedMain] .s.c.n.e.s.EurekaAutoServiceRegistration : Updating port to 8000
2022-05-30 16:46:16.911  INFO 8472 --- [ctor-http-nio-2] s.c.a.filter.GlobalFilter                : [Global Filter] baseMessage: Spring Cloud Gateway Global Filter
2022-05-30 16:46:16.912  INFO 8472 --- [ctor-http-nio-2] s.c.a.filter.GlobalFilter                : [Global Filter] start.. request id: 6e3a064c-1
2022-05-30 16:46:16.913  INFO 8472 --- [ctor-http-nio-2] s.c.a.filter.CustomFilter                : [Custom RRE Filter] request id: 6e3a064c-1
2022-05-30 16:46:20.936  INFO 8472 --- [ctor-http-nio-2] s.c.a.filter.CustomFilter                : [Custom POST Filter] response code: 200 OK
2022-05-30 16:46:20.936  INFO 8472 --- [ctor-http-nio-2] s.c.a.filter.GlobalFilter                : [Global Filter] end.. response code: 200 OK
2022-05-30 16:46:30.442  INFO 8472 --- [  restartedMain] s.c.a.ApiGatewayServiceApplication       : Started ApiGatewayServiceApplication in 49.832 seconds (JVM running for 54.235)
```

### ServerWebExchange - LoggingFilter

기존 Spring MVC 패턴을 사용할때 `ServletRequest`, `ServletResponse` 를 사용하였지만
`Spring 5.0` 에 새롭게 도입된 `WebFlux` 를 사용하게 되면 `ServerRequest`, `ServerResponse` 인스턴스를 사용하게 되는데이를 사용하게 해주는게 `ServerWebExchange` 임.




## 부가 설명

### application(.yml) 설정 부가 설명

```yaml
spring:
  application:
    name: apigateway-service
  cloud:
    gateway:
      routes:
        - id: first-service
          uri: http://localhost:8081/
          predicates:
            - Path=/first-service/**
        - id: second-service
          uri: http://localhost:8082/
          predicates:
            - Path=/second-service/**
```
> gateway 에서 내부 서비스로 매핑시 url 정보가 그대로 전달됨. <br>
> ex) 요청 url: http://localhost:8000/first-service/welcom <br>
>    gw -> `first-service` 요청: http://localhost:8001/first-service/welcome <br>
>  이때! `first-service` 는 `/first-service/welcome` 에 대한 매핑이 없으므로 `404 not found` 에러 발생! <br>
>  따라서 `first-service` 에서 `/` 로 되어 있는 `RequestMapping` 을 `/first-service` 로 변경 필요! <br>
> but, 위 내용은 `filter` 적용해서 해결 가능!