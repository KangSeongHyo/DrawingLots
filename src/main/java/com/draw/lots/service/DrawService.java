package com.draw.lots.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DrawService {

    private static final int FIRST = 0;
    

    public List<String> drawingLots(List<String> nameList, int count) {
        
        List<Integer> numberList = new ArrayList<>();

        int people = 0;
        
        while (people != count) {
            int number = new Random().nextInt(nameList.size());
            if(people != FIRST){
                if(numberList.contains(number)){
                    continue;
                }
            }
            numberList.add(number);
            people++;
        }

        List<String> pickList = numberList.stream()
                  .map(number->nameList.get(number))
                  .collect(Collectors.toList());
        
        return pickList;
    }

    


}
