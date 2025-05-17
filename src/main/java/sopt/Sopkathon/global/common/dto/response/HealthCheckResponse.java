package sopt.Sopkathon.global.common.dto.response;

public record HealthCheckResponse (
        String status,
        String port
) {
}