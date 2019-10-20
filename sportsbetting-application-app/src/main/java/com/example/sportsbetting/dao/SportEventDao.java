/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.SportEvent;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class SportEventDao extends GenericDao implements ISportEventDao {

    public void save(SportEvent event) {
        entityManager.persist(event);
    }

    public List<SportEvent> GetAllSportEvent() {
        List<SportEvent> list = entityManager
                .createQuery("SELECT se FROM SportEvent se", SportEvent.class)
                .getResultList();

        for (SportEvent sportEvent : list) {
            sportEvent.getBets().size();
            sportEvent.getResult();

        }
        return list;
    }

}
