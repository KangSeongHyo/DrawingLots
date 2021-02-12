package com.draw.lots.domain.calendar;

import com.draw.lots.service.CalendarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CalendarRunner implements CommandLineRunner {
    private static final int DEFAULT = 0;
    private final CalendarService calendarService;

    @Override
    public void run(String... args) throws Exception {
        calendarService.addCalendar(DEFAULT, DEFAULT);
    }
    
}
