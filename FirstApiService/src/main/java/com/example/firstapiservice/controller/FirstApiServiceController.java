package com.example.firstapiservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstApiServiceController {

    private Environment env;

    @Autowired
    public FirstApiServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First Api Service";
    }

    // Gateway 의 FilterConfig 에서 추가한 header 값 추가
    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        //System.out.println(header);
        log.info("[message] header: {}", header);
        return "Hello World in First Service.";
    }

    // Gateway 의 CustomFilter 테스트용
    @GetMapping("/check")
    public String check() {
        return "Check First Service.";
    }

    @GetMapping("/check/port")
    public String checkPort(HttpServletRequest request) {
        log.info("Server Port: {}", request.getServerPort());
//        return "Check First Service. on port: " + request.getServerPort();
        return String.format("Check First Service. on port: %s", env.getProperty("local.server.port"));
    }

}
