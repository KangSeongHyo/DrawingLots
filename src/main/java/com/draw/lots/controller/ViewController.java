package com.draw.lots.controller;

import java.util.List;

import com.draw.lots.controller.dto.CalendarDTO;
import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.user.User;
import com.draw.lots.service.CalendarService;
import com.draw.lots.service.DrawService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final DrawService drawService;
    private final CalendarService calendarService;

    @GetMapping("/calendar")
    public ModelAndView viewCalendar(@ModelAttribute RequestDTO requestDTO) throws Exception{
        
        ModelAndView modelAndView = new ModelAndView("calendar");
        CalendarDTO calendarDTO = calendarService.getCalendarList(requestDTO);
        modelAndView.addObject("calendarDTO",  calendarDTO);
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
    
}