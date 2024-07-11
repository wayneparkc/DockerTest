package com.ssafy.springboot01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    @Value("${server.env}")
    private String env;

    @Value("${server.address}")
    private String address;

    @Value("${server.port}")
    private String port;

    @Value("${serverName}")
    private String serverName;

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Test Complete");
    }

    @GetMapping("/hc")
    public ResponseEntity<HashMap<String, String>> healthCheck() {
        HashMap<String, String> map = new HashMap<>();
        map.put("env", env);
        map.put("address", address);
        map.put("port", port);
        map.put("serverName", serverName);
        return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.OK);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv() {
        return new ResponseEntity<>(env, HttpStatus.OK);
    }
}
