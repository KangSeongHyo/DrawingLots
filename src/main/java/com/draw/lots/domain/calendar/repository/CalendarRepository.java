package com.draw.lots.domain.calendar.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.calendar.Calendar;
import com.draw.lots.domain.user.User;

import org.springframework.stereotype.Repository;


@Repository
public class CalendarRepository {
    
    @PersistenceContext
    EntityManager em;

    public void saveList(List<User> pickUserList, DrawRequestDTO drawRequestDTO) {
        
        LocalDateTime localDateTime = LocalDateTime.now();

        for(User user : pickUserList){
            Calendar calendar = Calendar.builder()
            .year(localDateTime.getYear())
            .month(localDateTime.getMonthValue())
            .day(localDateTime.getDayOfMonth())
            .bet(drawRequestDTO.getBet())
            .userId(user.getId())
            .title(drawRequestDTO.getTitle())
            .build();

            em.persist(calendar);
        }
    }

}
