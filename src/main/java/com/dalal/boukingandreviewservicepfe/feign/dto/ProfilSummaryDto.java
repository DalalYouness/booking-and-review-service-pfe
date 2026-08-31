package com.dalal.boukingandreviewservicepfe.feign.dto;

import lombok.Builder;

@Builder
public record ProfilSummaryDto(
        Long id,
        String firstName,
        String lastName,
        String photoUrl
) {
    public String getFullName() {
        return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "").trim();
    }
}