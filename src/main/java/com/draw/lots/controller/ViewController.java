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
    public ModelAndView viewCalendar() throws Exception{
        
        ModelAndView modelAndView = new ModelAndView("calendar");
        
        return modelAndView;
    }

    @GetMapping("/create/user")
    public ModelAndView viewRegister() {
        
        ModelAndView modelAndView = new ModelAndView("user");
        
        return modelAndView;
    }

    @GetMapping("/draw")
    public ModelAndView viewDrawingLots() {
        
        ModelAndView modelAndView = new ModelAndView("draw");
        
        return modelAndView;
    }
    
}