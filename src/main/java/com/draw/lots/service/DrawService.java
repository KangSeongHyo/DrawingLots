package com.draw.lots.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.log.repository.LogRepository;
import com.draw.lots.domain.user.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DrawService {

    private static final int FIRST = 0;

    private final UserService userService;
    private final CalendarService calendarService;
    private final LogRepository logRepository;

    @Transactional
    public List<User> drawingLots(DrawRequestDTO drawRequestDTO) {
        
        int count = drawRequestDTO.getCount();
        List<String> nameList = drawRequestDTO.getName().stream()
        .filter(name->!"".equals(name))
        .collect(Collectors.toList());

        List<Integer> numberList = new ArrayList<>();
        List<String> pickList = new ArrayList<>();

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

        for(int number : numberList){
            pickList.add(nameList.get(number));
        }
        int bet = drawRequestDTO.getBet();
        bet/=count;
        drawRequestDTO.setBet(bet);
        
        userService.updateAmount(pickList, drawRequestDTO);
        List<User> pickUserList= userService.getUserList(pickList);
        calendarService.addResultInCalendar(pickUserList, drawRequestDTO);
        logRepository.saveLog(pickList, drawRequestDTO);

        return pickUserList;
    }

}
