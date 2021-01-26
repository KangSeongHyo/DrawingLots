package com.draw.lots.controller;


import com.draw.lots.domain.user.repository.UserRepository;
import com.draw.lots.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;
 
    @Test
    public void 유저컨트롤러테스트() throws Exception {


       mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").param("name", "김영희"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    }

}
