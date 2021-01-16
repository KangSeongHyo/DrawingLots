package com.draw.lots.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserJpaTest {

    @Autowired
    EntityManager em;

    @Test
    public void 유저JPA테스트() {
        

        String name = "김철수";

        User user = User.builder().name(name).build();
                                          
        em.persist(user);

        User findUser = em.find(User.class,user.getId());
        
        assertEquals(name, findUser.getName());

    }

}