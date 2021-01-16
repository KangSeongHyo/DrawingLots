package com.draw.lots.domain.calendar.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.calendar.Calendar;

import org.springframework.stereotype.Repository;


@Repository
public class CalendarRepository {
    

    @PersistenceContext
    EntityManager em;

    public void saveList(List<Long> pickIdList, RequestDTO requestDTO) {
        
        for(long userId : pickIdList){

            Calendar calendar = Calendar.builder()
            .year(requestDTO.getYear()).month(requestDTO.getMonth()).day(requestDTO.getDay())
            .bet(requestDTO.getBet())
            .userId(userId)
            .title(requestDTO.getTitle())
            .build();

            em.persist(calendar);
        }
    }

}
