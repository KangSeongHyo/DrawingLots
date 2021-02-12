package com.draw.lots.controller.dto;

import java.util.List;

import com.draw.lots.domain.calendar.Calendar;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class CalendarDTO {

    List<Calendar> calendarList;
    int startDay;
    int year;
    int month;
    
    @Override
    public String toString() {
        return year+" "+month+" "+startDay;
    }
}
