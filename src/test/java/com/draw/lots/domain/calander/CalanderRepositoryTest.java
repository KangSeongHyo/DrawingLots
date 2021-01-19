
package com.draw.lots.domain.calander;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.draw.lots.domain.calendar.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

/**
 * CalanderRepositoryTest
 */


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CalanderRepositoryTest {
    
    @Autowired
    EntityManager em;
    
    @Test
    @Rollback(false)
    public void 캘린더생성테스트() {
        
        List<Long> pickList = Arrays.asList(1L,2L);
        String title = "점심 커피";
        int bet = 5000;
        int year = 2020;
        int month = 1;
        int day = 16;
        
        for(long userId : pickList){

            Calendar calendar = Calendar.builder()
            .year(year).month(month).day(day)
            .bet(bet)
            .userId(userId)
            .title(title)
            .build();

            em.persist(calendar);
        }
             
    }
}