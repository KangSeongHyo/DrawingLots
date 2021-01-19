
package com.draw.lots.service;

import com.draw.lots.controller.dto.RequestDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

/**
 * ServiceIntegratedTest
 */

@SpringBootTest
public class ServiceIntegratedTest {

    @Autowired
    UserService userService;

    @Autowired
    DrawService drawService;

    @Autowired
    CalendarService calendarService;

    @Test
    public void 통합테스트() {
        int year = 2020;
        int month = 1;
        int day = 17;
        int bet = 15000;
        String title = "점심값";

        RequestDTO requestDTO = RequestDTO.builder()
        .year(year)
        .month(month)
        .day(day)
        .build();
    }
    
}