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
public interface IWagerDao {

    public void InsertWager(Wager wager);
    
    public List<Wager> GetWager();
}
