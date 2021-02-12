package com.draw.lots.domain.calendar.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.draw.lots.controller.dto.CalendarDTO;
import com.draw.lots.controller.dto.RequestDTO;
import com.draw.lots.domain.calendar.Calendar;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CalendarRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveAll(List<Calendar> calendarList) {
        calendarList.forEach(calendar->em.persist(calendar));
    }

    @Transactional
    public List<Calendar> getAll(CalendarDTO calendarDTO){

       /*  String jpql = "select distinct c, cd from Calendar c left join c.calendarDataList cd"
            + " on c.year = cd.year and c.month = cd.month and c.day = cd.day"
            + " where c.year=:year and c.month=:month";  */
            
        String jpql = "select distinct c from Calendar c left join fetch c.calendarDataList" 
        +" where  c.year=:year and c.month=:month"
        +" order by c.day asc";

        Query createQuery = em.createQuery(jpql);
        createQuery.setParameter("year", calendarDTO.getYear());
        createQuery.setParameter("month", calendarDTO.getMonth());

        return (List<Calendar>) createQuery.getResultList();
    }
    
    public long getCount(int year,int month) {
        String jpql = "select count(c.day) from Calendar c where c.year=:year and c.month=:month";

        Query createQuery = em.createQuery(jpql);

        createQuery.setParameter("year", year);
        createQuery.setParameter("month", month);

        return (long) createQuery.getSingleResult();
    }

}
