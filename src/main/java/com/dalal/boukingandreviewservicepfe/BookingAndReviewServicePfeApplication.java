package com.dalal.boukingandreviewservicepfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingAndReviewServicePfeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingAndReviewServicePfeApplication.class, args);
    }

}
