package com.draw.lots.domain.user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.draw.lots.controller.dto.RequestDTO;
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

   private static final int FAIL = 0;

   private final EntityManager em;

   @Transactional
   public void save(String name) {
        
     try {

         User userEntity = User.builder().name(name).build();

         em.persist(userEntity);
        
     } catch (Exception e) {

         log.error( "유저 생성에 실패했습니다." , e.toString());

     }  
   }    

   @Transactional
   public int updateAmount(List<Long> pickList,RequestDTO requestDTO) {

       String jpql = "UPDATE User u SET u.amount = u.amount + :bet WHERE u.id IN :pickList";

       try {

            Query query =  em.createQuery(jpql);

            query.setParameter("bet", requestDTO.getBet());
            query.setParameter("pickList", pickList);
    
            return query.executeUpdate();
           
       } catch (Exception e) {

            log.error("결과업데이트에 실패했습니다.",e); 
       
       }
       return FAIL;
   }
}