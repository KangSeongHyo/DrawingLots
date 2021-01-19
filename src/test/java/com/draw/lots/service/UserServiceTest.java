package com.draw.lots.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.user.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {
    
    @MockBean
    DrawService drawService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 결과업데이트하기() {

        int year = 2020;
        int month = 1;
        int day = 17;
        int bet = 15000;
        String title = "점심값";

        RequestDTO requestDTO = RequestDTO.builder()
        .year(year)
        .month(month)
        .day(day)
        .build();

        List<Long> idList = Arrays.asList(1L,2L);

        when(drawService.drawingLots(idList, 1))
        .thenReturn(Arrays.asList(1L));

       List<Long> pickList =  drawService.drawingLots(idList, 1);

       assertEquals(1, pickList.size());
      
       userRepository.updateAmount(pickList, requestDTO);

    }

}
