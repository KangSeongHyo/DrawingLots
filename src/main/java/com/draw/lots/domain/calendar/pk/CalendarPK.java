package com.draw.lots.domain.calendar.pk;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CalendarPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int year;
    private int month;
    private int day;
}
