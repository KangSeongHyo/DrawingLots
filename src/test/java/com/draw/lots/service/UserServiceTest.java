package com.draw.lots.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.user.User;
import com.draw.lots.domain.user.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
public class UserServiceTest {
    
    private static final int FAIL = 0;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void 결과업데이트하기() {

        int bet = 15000;
        String title = "점심값";

        DrawRequestDTO drawRequestDTO = DrawRequestDTO.builder()
        .name(Arrays.asList("김철수","김영희"))
        .bet(bet)
        .title(title)
        .build();

        List<String> pickNameList = Arrays.asList("김철수");

        int result = userRepository.updateAmount(pickNameList, drawRequestDTO);
        assertNotEquals(FAIL, result);
    }

    @Test
    public void 유저이름검색테스트() {

        String key = "USER_NAME";
       
        HashOperations<String,String,Integer> hashOperations= redisTemplate.opsForHash();
        Set<String> a = hashOperations.keys(key);

        hashOperations.put(key, "김철수", 0);
        hashOperations.put(key, "김수철", 0);

        ScanOptions scanOptions = ScanOptions.scanOptions().match("김*").build();
        Cursor<Entry<String,Integer>> cursor= hashOperations.scan(key, scanOptions);
        List<String> searchList = new ArrayList<>();

        while(cursor.hasNext()){
            Entry<String,Integer> entry = cursor.next();
            searchList.add(entry.getKey());
        }

        assertEquals(searchList.size(), 2);
    }


}
