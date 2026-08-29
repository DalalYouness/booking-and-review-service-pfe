package com.dalal.boukingandreviewservicepfe.feign.dto;

import lombok.Builder;

@Builder
public record ServiceSummaryDto(
        String serviceName
) {
}
