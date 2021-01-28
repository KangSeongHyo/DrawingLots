package com.draw.lots.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.user.User;
import com.draw.lots.domain.user.repository.UserRepository;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final RedisTemplate<String,Object> redisTemplate;

    private static final String SEARCH_KEY = "USER_NAME";
    private static final String ASTERISK  = "*";
    private static final int TIME_LIMIT = 5;

    public void createUser(RequestDTO requestDTO) {   
        userRepository.save(requestDTO.getName());
    }
    public void updateAmount(List<String> pickList,DrawRequestDTO drawRequestDTO){
        userRepository.updateAmount(pickList, drawRequestDTO);
    }

    public List<User> getUserList(List<String> pickList){
       return userRepository.findByNameList(pickList);
    }


    public List<String> getSearchNameList(RequestDTO requestDTO){

        HashOperations<String,String,Long> hashOperations= redisTemplate.opsForHash();
        
        if(redisTemplate.getExpire(SEARCH_KEY) < 0){
            List<User> nameList = userRepository.findAll();
            Map<String,Long> nameDataMap = nameList.stream()
            .collect(Collectors.toMap(User::getName,User::getId));
            hashOperations.putAll(SEARCH_KEY, nameDataMap);
            redisTemplate.expire(SEARCH_KEY,TIME_LIMIT,TimeUnit.SECONDS);
        }
               
        ScanOptions scanOptions = ScanOptions.scanOptions().match(requestDTO.getName()+ASTERISK).build();
        Cursor<Entry<String,Long>> cursor= hashOperations.scan(SEARCH_KEY, scanOptions);
        List<String> searchList = new ArrayList<>();

        while(cursor.hasNext()){
            Entry<String,Long> entry = cursor.next();
            searchList.add(entry.getKey());
        }

        return searchList;
    }
}
