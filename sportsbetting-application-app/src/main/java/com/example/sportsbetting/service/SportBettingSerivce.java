/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.service;

import com.example.sportsbetting.dao.IOutComeOddDao;
import com.example.sportsbetting.dao.IPlayerDao;
import com.example.sportsbetting.dao.ISportEventDao;
import com.example.sportsbetting.dao.IWagerDao;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sanyi
 */
public class SportBettingSerivce implements ISportsBettingService {

    @Autowired
    private ISportEventDao sportEventDao;

    @Autowired
    private IWagerDao wagerDao;

    @Autowired
    private IPlayerDao playerDao;

    @Autowired
    private IOutComeOddDao outcomeOddDao;

    public SportBettingSerivce() {
    }

    @Override
    public void savePlayer(Player player) {
        this.playerDao.AddPlayer(player);
    }

    @Override
    public Player findPlayer() {
        return this.playerDao.GetActualPlayer();
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return this.sportEventDao.GetAllSportEvents();
    }

    @Override
    public void saveWage(Wager wager) {
        this.wagerDao.InsertWager(wager);
    }

    @Override
    public List<Wager> findAllWagers() {
        return this.wagerDao.GetWagers();
    }

    @Override
    public void calculateResults() {
        List<Wager> wagerList = this.wagerDao.GetWagers();
        Player player = this.playerDao.GetActualPlayer();
        for (Wager wager : wagerList) {
            if (wager.isWin()) {
                BigDecimal val = wager.getOdd().getValue().multiply(wager.getAmount());
                BigDecimal newBalance = player.getBalance().add(val);
                
                // Update local resource
                player.setBalance(newBalance);
                
                //Update in database
                this.playerDao.UpdatePlayerBalance(newBalance);
            }
        }
    }

    public void InsertOutcomeOdd(OutcomeOdd odd) {
        this.outcomeOddDao.InsertOutcomeOdd(odd);
    }

    public void updatePlayerBalance(BigDecimal newVal) {
        this.playerDao.UpdatePlayerBalance(newVal);
    }
}
