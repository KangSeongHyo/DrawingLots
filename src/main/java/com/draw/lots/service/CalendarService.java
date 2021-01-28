package com.draw.lots.service;

import java.util.List;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.calendar.repository.CalendarRepository;
import com.draw.lots.domain.user.User;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * CalendarService
 */
@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;
    
    public void addResultInCalendar(List<User> pickUserList, DrawRequestDTO drawRequestDTO){
        calendarRepository.saveList(pickUserList, drawRequestDTO);
    }

}