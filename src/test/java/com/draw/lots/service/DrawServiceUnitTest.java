package com.draw.lots.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


public class DrawServiceUnitTest {
    
    private static final int FIRST = 0;


    @Test
    public void 유저추첨하기(){ 
       
        List<String> nameList = new ArrayList<>();
        int people = 1;
       
        nameList.add("김철수");
        nameList.add("김나영");
        nameList.add("김영희");
        nameList.add("황호준");
        
        List<Integer> numberList = new ArrayList<>();

        int count = 0;
        
        while (count != people) {
            int number = new Random().nextInt(nameList.size());
            if(count != FIRST){
                if(numberList.contains(number)){
                    continue;
                }
            }
            numberList.add(number);
            count++;
        }

        List<String> pickList = numberList.stream()
                  .map(number->nameList.get(number))
                  .collect(Collectors.toList());
        
        pickList.stream().forEach(System.out::println);

        assertEquals(people, pickList.size());
    }


}
