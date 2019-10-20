/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.OutcomeOdd;

/**
 *
 * @author Sanyi
 */
public class OutComeOddDao extends GenericDao implements IOutComeOddDao {

    public void InsertOutcomeOdd(OutcomeOdd outcomeodd) {
        entityManager.persist(outcomeodd);
    }

}
