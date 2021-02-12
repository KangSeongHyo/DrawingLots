package com.draw.lots.domain.calendar;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.draw.lots.domain.calendar.pk.CalendarPK;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Calendar")
@IdClass(CalendarPK.class)
public class Calendar {

    @Id
    private int year;
    
    @Id
    private int month;
    
    @Id
    private int day;

    
    @MapsId
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "year",referencedColumnName = "year"),
        @JoinColumn(name = "month",referencedColumnName = "month"),
        @JoinColumn(name = "day",referencedColumnName = "day")
    })
    List<CalendarData> calendarDataList;

}
