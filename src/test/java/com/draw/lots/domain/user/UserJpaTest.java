package com.draw.lots.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserJpaTest {

    @Autowired
    EntityManager em;

    @Test
    @Order(1)
    public void 유저JPA테스트() {
        

        String name = "김철수";

        User user = User.builder().name(name).build();
                                          
        em.persist(user);

        User findUser = em.find(User.class,user.getId());
        
        assertEquals(name, findUser.getName());

    }

    @Test
    @Order(2)
    public void 누적금액JPA테스트() {

        List<Long> pickList = Arrays.asList(1L,2L);
        int bet = 5000;

        String jpql = "UPDATE User u SET u.amount = u.amount + :bet WHERE u.id IN :pickList";

        Query query =  em.createQuery(jpql);

        query.setParameter("bet", bet);
        query.setParameter("pickList", pickList);

        int result = query.executeUpdate();

        assertEquals(1, result);

    }

}