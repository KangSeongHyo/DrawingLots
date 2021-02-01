package com.draw.lots.domain.calander;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import com.draw.lots.domain.calendar.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CalendarJpaTest {

    @Autowired
    EntityManager em;

    
    @Test
    public void 캘린더JPA테스트() {

        int year = 2020;
        int month = 1;
        int day = 16;

        Calendar calendar = Calendar.builder()
        .year(year).month(month).day(day)
        .build();

        em.persist(calendar);

        Calendar actualCalender = em.find(Calendar.class,calendar.getId());
         
        assertEquals(year,actualCalender.getYear());

    }
    
}
