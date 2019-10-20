/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.Wager;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class WagerDao extends GenericDao implements IWagerDao {

    public void InsertWager(Wager wager) {
        entityManager.persist(wager);
    }

    public List<Wager> GetWager() {
        List<Wager> list = entityManager.createQuery("SELECT wager FROM Wager wager", Wager.class).getResultList();

        return list;
    }

}
