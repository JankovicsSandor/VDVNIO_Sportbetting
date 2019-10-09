/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.Database;
import domain.Player;
import domain.SportEvent;
import domain.Wager;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class SportBettingSerivce implements ISportsBettingService {

    private final Database database;

    public SportBettingSerivce(Database database) {
        this.database=database;
    }

    
    @Override
    public void savePlayer(Player player) {
        this.database.setPlayer(player);
    }

    @Override
    public Player findPlayer() {
       return this.database.getPlayer();
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return this.database.getSportEvent();
    }

    @Override
    public void saveWage(Wager wager) {
        this.database.setWager(wager);
    }

    @Override
    public List<Wager> findAllWagers() {
       return this.database.getWager();
    }

    @Override
    public void calculateResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
