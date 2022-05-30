package com.example.secondapiservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@Slf4j
public class SecondApiServiceController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Second Api Service";
    }

    // Gateway 의 FilterConfig 에서 추가한 header 값 추가
    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {
        //System.out.println(header);
        log.info("[message] header: {}", header);
        return "Hello World in Second Service.";
    }

    // Gateway 의 CustomFilter 테스트용
    @GetMapping("/check")
    public String check() {
        return "Check Second Service.";
    }
}
