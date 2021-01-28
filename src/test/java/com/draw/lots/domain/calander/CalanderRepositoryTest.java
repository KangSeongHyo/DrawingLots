
package com.draw.lots.domain.calander;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.draw.lots.domain.calendar.Calendar;
import com.draw.lots.domain.calendar.repository.CalendarRepository;

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
    CalendarRepository calendarRepository;
    
    @Test
    @Rollback(false)
    public void 캘린더생성테스트() {
        
        
        //calendarRepository.saveList(pickIdList, drawRequestDTO);
             
    }
}