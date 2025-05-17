package sopt.Sopkathon.global.common.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.global.common.dto.response.HealthCheckResponse;

@Hidden
@RestController
@RequiredArgsConstructor
public class StatusCheckController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/health-check")
    public ResponseEntity<HealthCheckResponse> checkHealthStatus() {
        HealthCheckResponse body = new HealthCheckResponse("UP", serverPort);
        return ResponseEntity.ok(body);
    }
}
