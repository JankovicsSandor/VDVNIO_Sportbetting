/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.OutcomeOdd;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sanyi
 */
public interface IOutComeOddDao {

    @Transactional
    public void InsertOutcomeOdd(OutcomeOdd outcomeodd);
}
