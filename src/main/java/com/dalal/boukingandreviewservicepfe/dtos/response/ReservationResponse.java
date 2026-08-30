package com.dalal.boukingandreviewservicepfe.dtos.response;

import com.dalal.boukingandreviewservicepfe.enums.BookingStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReservationResponse(
        Long id,
        LocalDateTime dateRdv,
        Integer dureeReel,
        BookingStatus status,
        Long idClient,
        Long idProvider,
        Long idService,
        String providerName,
        String clientName,
        String serviceName

) {}
