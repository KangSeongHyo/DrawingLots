package com.draw.lots.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.draw.lots.controller.dto.CalendarDTO;
import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.calendar.Calendar;
import com.draw.lots.domain.calendar.repository.CalendarDataRepository;
import com.draw.lots.domain.calendar.repository.CalendarRepository;
import com.draw.lots.domain.user.User;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CalendarService
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarDataRepository calendarDataRepository;
    private final CalendarRepository calendarRepository;
    private static final int DEFAULT = 0;
   
    public void addResultInCalendar(List<User> pickUserList, DrawRequestDTO drawRequestDTO){
        calendarDataRepository.saveList(pickUserList, drawRequestDTO);
    }

    public CalendarDTO addCalendar(int year, int month){
        if(year == DEFAULT){
            year = LocalDateTime.now().getYear();
            month = LocalDateTime.now().getMonth().getValue();   
        }

       if(calendarRepository.getCount(year, month) == 0){
          List<Calendar> calendarList = new ArrayList<>();
          int lengthOfMonth = YearMonth.of(year, month).lengthOfMonth();
         
         for(int day = 1; day <= lengthOfMonth; day++){
            Calendar calendar = Calendar.builder()
            .year(year)
            .month(month)
            .day(day)
            .build();
            
            calendarList.add(calendar);
         }
         calendarRepository.saveAll(calendarList);
       }

       CalendarDTO calendarDTO = new CalendarDTO();
       calendarDTO.setStartDay(LocalDate.of(year, month, 1).getDayOfWeek().getValue());
       calendarDTO.setYear(year);
       calendarDTO.setMonth(month);
       return calendarDTO;
    }

    public CalendarDTO getCalendarList(RequestDTO requestDTO){
        log.info(requestDTO.toString());
        CalendarDTO calendarDTO = addCalendar(requestDTO.getYear(), requestDTO.getMonth());
        List<Calendar> calendarList = calendarRepository.getAll(calendarDTO);
        calendarDTO.setCalendarList(calendarList);
        return calendarDTO;
    }

    @Scheduled(cron = " 0 0 0 1 * *")
    public void addCalendar(){
       addCalendar(DEFAULT, DEFAULT);
    }
}