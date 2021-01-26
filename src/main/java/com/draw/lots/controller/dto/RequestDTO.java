package com.draw.lots.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    private List<Long> userIdList;
    private int year;
    private int month;
    private int day;
    private int bet;
    private String title;
    @Setter
    private String name;

}
