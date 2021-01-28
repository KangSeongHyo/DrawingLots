package com.draw.lots.controller;

import java.util.List;

import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody RequestDTO requestDTO){
        
        userService.createUser(requestDTO);
        
        
        return ResponseEntity.ok().build();
        
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<String>> getUserByName(@ModelAttribute RequestDTO requestDTO){
        
        return ResponseEntity.ok(userService.getSearchNameList(requestDTO));
        
    }

}
