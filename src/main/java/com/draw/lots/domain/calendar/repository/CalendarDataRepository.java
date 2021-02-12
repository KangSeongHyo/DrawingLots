package com.draw.lots.domain.calendar.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.calendar.CalendarData;
import com.draw.lots.domain.user.User;

import org.springframework.stereotype.Repository;


@Repository
public class CalendarDataRepository {
    
    @PersistenceContext
    EntityManager em;

    public void saveList(List<User> pickUserList, DrawRequestDTO drawRequestDTO) {
        
        LocalDateTime localDateTime = LocalDateTime.now();

        for(User user : pickUserList){
            CalendarData calendarData = CalendarData.builder()
            .year(localDateTime.getYear())
            .month(localDateTime.getMonthValue())
            .day(localDateTime.getDayOfMonth())
            .bet(drawRequestDTO.getBet())
            .name(user.getName())
            .userId(user.getId())
            .title(drawRequestDTO.getTitle())
            .build();

            em.persist(calendarData);
        }
    }

}
