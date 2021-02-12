package com.draw.lots.domain.calendar;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.draw.lots.domain.calendar.pk.CalendarDataPK;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(CalendarDataPK.class)
@SequenceGenerator(
    name = "CALENDAR_DATA_GENERATOR",
    sequenceName = "CALENDAR_DATA_SEQUENCE",
    initialValue = 1,
    allocationSize = 1)
@Table(name = "CalendarData")
public class CalendarData {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALENDAR_DATA_SEQUENCE")
    private long seq;
    
    private int year;
    
    private int month;
    
    private int day;

    private String name;

    private long userId;

    private String title;

    @ColumnDefault("0")
    private int bet;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}