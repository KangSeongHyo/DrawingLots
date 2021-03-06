package com.draw.lots.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.user.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
    
    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저생성테스트() {
        
        String name = "김철수";

        userRepository.save(name);
    
        User user = em.find(User.class, 1L);

        assertEquals(name, user.getName()); 

    }

    @Test
    public void 유저중복테스트() {
        
        String name = "김철수";

        userRepository.save(name);

        assertThrows(DataIntegrityViolationException.class, ()->{
            userRepository.save(name);
        });

    }


    @Test
    public void 누적금액업데이트() {

        List<String> pickList = Arrays.asList("김철수","김영희");
        
        DrawRequestDTO requestDTO = DrawRequestDTO.builder().bet(1000).build();
        
        int result = userRepository.updateAmount(pickList, requestDTO);

        assertNotEquals(0,result);
        
    }
}
