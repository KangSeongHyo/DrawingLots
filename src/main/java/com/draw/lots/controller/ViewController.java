package com.draw.lots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * CalendarViewController
 */

@Controller
public class ViewController {

    @GetMapping("/calendar")
    public ModelAndView viewCalendar() {
        
        ModelAndView modelAndView = new ModelAndView("calendar");
        
        return modelAndView;
    }
    
    
}