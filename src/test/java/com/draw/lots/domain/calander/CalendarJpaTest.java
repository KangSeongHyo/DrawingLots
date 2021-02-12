package com.draw.lots.domain.calander;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Map;

import javax.persistence.EntityManager;

import com.draw.lots.domain.calendar.Calendar;
import com.draw.lots.domain.calendar.CalendarData;

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

        CalendarData calendar = CalendarData.builder()
        .year(year).month(month).day(day)
        .build();

        em.persist(calendar);

        CalendarData actualCalender = em.find(CalendarData.class,calendar.getSeq();
         
        assertEquals(year,actualCalender.getYear());

    }

    @Test
    public void 캘린더만들기테스트() {

        int year = 2020;
        int month = 10;

        int lengthOfMonth = YearMonth.of(year, month).lengthOfMonth();
        
        for(int day = 1; day <= lengthOfMonth; day++){
            Calendar calendar = Calendar.builder()
            .year(year)
            .month(month)
            .day(day)
            .build();

            em.persist(calendar);
        }
    }
    
}
