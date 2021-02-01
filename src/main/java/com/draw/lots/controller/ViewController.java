package com.draw.lots.controller;

import java.util.List;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.user.User;
import com.draw.lots.service.DrawService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

/**
 * CalendarViewController
 */

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final DrawService drawService;

    @GetMapping("/calendar")
    public ModelAndView viewCalendar() throws Exception{
        
        ModelAndView modelAndView = new ModelAndView("calendar");
        
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView viewRegister() {
        
        ModelAndView modelAndView = new ModelAndView("user");
        
        return modelAndView;
    }

    @GetMapping("/draw")
    public ModelAndView viewDrawingLots() {
        
        ModelAndView modelAndView = new ModelAndView("draw");
        
        return modelAndView;
    }   
    
    @PostMapping("/result")
    public ModelAndView viewResult(@ModelAttribute DrawRequestDTO drawRequestDTO) {
        ModelAndView modelAndView = new ModelAndView("result");
        
        List<User> pickUserList = drawService.drawingLots(drawRequestDTO);
        modelAndView.addObject("pickUserList", pickUserList);
        
        return modelAndView;
    }

    @GetMapping("/result")
    public ModelAndView viewResults() {
        ModelAndView modelAndView = new ModelAndView("result");
        
        return modelAndView;
    }
    
}