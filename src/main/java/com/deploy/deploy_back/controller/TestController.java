package com.deploy.deploy_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${client.address}")
    // application.yml의 클라이언트 주소를 불러와서 clientAddress 이름으로 저장
    private String clientAddress;

    @CrossOrigin(origins = "http://react9955.s3-website.ap-northeast-2.amazonaws.com")
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok().body(clientAddress + " 테스트! 홍길동");
    }
}
