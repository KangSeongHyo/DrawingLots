package com.draw.lots.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CalendarServiceUnitTest {


    @PersistenceContext
    EntityManager em;


}
