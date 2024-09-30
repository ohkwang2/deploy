package com.deploy.deploy_back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// 서버가 잘 돌아가고 있는지 확인하는 컨트롤러
@RestController
public class HealthCheckController {

    @Value("${spring.profiles.active}")
    // 현재 실행중인 서버
    private String env;

    @Value("${server.port}")
    // 현재 실행중인 포트
    private String port;

    @GetMapping("/health/check")
    public ResponseEntity<?> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("env", env);
        response.put("port", port);
        return ResponseEntity.ok().body(response);
    }
}
