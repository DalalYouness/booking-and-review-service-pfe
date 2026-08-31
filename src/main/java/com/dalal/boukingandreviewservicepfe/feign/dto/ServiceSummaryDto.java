package com.dalal.boukingandreviewservicepfe.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ServiceSummaryDto(
        // because the data provided by provider service content about service
        // the service name mentioned as name
        Long id,
        @JsonProperty("name")String serviceName
) {
}
