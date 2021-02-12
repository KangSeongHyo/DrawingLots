package com.draw.lots.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.draw.lots.controller.dto.CalendarDTO;
import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.calendar.Calendar;
import com.draw.lots.domain.calendar.CalendarData;
import com.draw.lots.domain.calendar.repository.CalendarDataRepository;
import com.draw.lots.domain.calendar.repository.CalendarRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("local")
public class CalendarServiceTest {
    
    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    CalendarDataRepository calendarDataRepository;

    @Autowired
    CalendarService calendarService;

    @Test
    public void 달력가져오기테스트() {
       
        CalendarDTO calendarDTO = new CalendarDTO();
        calendarDTO.setMonth(2021);
        calendarDTO.setYear(2);        

        List<Calendar> calendars = calendarRepository.getAll(calendarDTO);
        List<CalendarData> calendarDataList = calendars.get(10).getCalendarDataList();

        assertEquals(28, calendars.size());
        assertEquals(3, calendarDataList.size());
    }

    @Test
    public void 달력만들기테스트() {
        RequestDTO requestDTO = RequestDTO.builder()
        .year(2021)
        .month(2)
        .day(10)
        .build();

        calendarService.addCalendar(requestDTO.getYear(),requestDTO.getMonth());
    }
}
