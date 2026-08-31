package com.dalal.boukingandreviewservicepfe.feign.client;

import com.dalal.boukingandreviewservicepfe.feign.dto.ServiceSummaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROVIDER-CONTENT-SERVICE-PFE")
public interface ServiceClient {
    @GetMapping("/api/v1/service/category/{id}")
    ServiceSummaryDto getServiceSummary(@PathVariable Long id);
}
