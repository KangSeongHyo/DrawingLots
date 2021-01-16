package com.draw.lots.controller.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class RequestDTO {

    private List<Long> userIdList;
    private int year;
    private int month;
    private int day;
    private int bet;
    private String title;

}
