package com.draw.lots.domain.user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.draw.lots.controller.dto.DrawRequestDTO;
import com.draw.lots.domain.user.User;

import org.hibernate.exception.ConstraintViolationException;
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
        
     User userEntity = User.builder().name(name).build();
     em.persist(userEntity);
    
   }
   
   @Transactional
   public List<User> findAll() {
        
        String jpql = "SELECT u FROM User u";
        Query createQuery = em.createQuery(jpql);
        
        return createQuery.getResultList();
    
   } 

   @Transactional
   public List<User> findByNameList(List<String> pickList) {
        
        String jpql = "SELECT u FROM User u WHERE u.name IN :pickList";
        Query createQuery = em.createQuery(jpql);
        createQuery.setParameter("pickList", pickList);
        
        return createQuery.getResultList();
    
   } 

   @Transactional
   public int updateAmount(List<String> pickList,DrawRequestDTO drawRequestDTO) {

       String jpql = "UPDATE User u SET u.amount = u.amount + :bet WHERE u.name IN :pickList";

       try {

            Query createQuery =  em.createQuery(jpql);

            createQuery.setParameter("bet", drawRequestDTO.getBet());
            createQuery.setParameter("pickList", pickList);
    
            return createQuery.executeUpdate();
           
       } catch (Exception e) {

            log.error("결과업데이트에 실패했습니다.",e); 
       
       }
       return FAIL;
   }
}