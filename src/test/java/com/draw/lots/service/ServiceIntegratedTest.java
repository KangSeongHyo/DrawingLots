
package com.draw.lots.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }
    
}