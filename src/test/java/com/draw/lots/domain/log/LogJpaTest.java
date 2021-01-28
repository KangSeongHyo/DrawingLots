package com.draw.lots.domain.log;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import com.draw.lots.domain.log.Log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LogJpaTest {
    
    @Autowired
    EntityManager em;

    
    @Test
    public void 로그JPA테스트() {

        String subject = "아침 커피";

        Log log = Log.builder().title(subject).build();

        em.persist(log);

        assertEquals(subject, log.getTitle());
       
    }
}
