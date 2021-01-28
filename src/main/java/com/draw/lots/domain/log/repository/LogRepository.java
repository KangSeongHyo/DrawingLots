package com.draw.lots.domain.log.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.log.Log;

import org.springframework.stereotype.Repository;

/**
 * LogRepository
 */
@Repository
public class LogRepository {

    @PersistenceContext
    EntityManager em;

    public void saveLog(List<String> pickList,DrawRequestDTO drawRequestDTO){
        String pick = pickList.stream()
        .collect(Collectors.joining(","));
    
        Log log = Log.builder()
        .title(drawRequestDTO.getTitle())
        .bet(drawRequestDTO.getBet())
        .pickName(pick)
        .build(); 

        em.persist(log);
    }
    
}