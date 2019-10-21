/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.service;


import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public interface ISportsBettingService {
    void savePlayer(Player player);
    void updatePlayerBalance(BigDecimal newVal);
    Player findPlayer();
    List<SportEvent> findAllSportEvents();
    void saveWage(Wager wager);
    List<Wager> findAllWagers();
    void calculateResults();
    void InsertOutcomeOdd(OutcomeOdd odd);
}