package com.draw.lots.domain.user.repository;

import javax.persistence.EntityManager;

import com.draw.lots.domain.user.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * UserRepository
 */

@Slf4j
@RequiredArgsConstructor
@Repository
public class UserRepository {


   private final EntityManager em;

   @Transactional
   public void save(String name) {
        
     try {

         User userEntity = User.builder().name(name).build();

         
         em.persist(userEntity);
        
     } catch (Exception e) {

         log.error( "유저 생성에 실패했습니다." , e.toString());

     } finally{

         em.close();
     }
        
   }    

}