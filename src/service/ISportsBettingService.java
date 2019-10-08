/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Player;
import domain.SportEvent;
import domain.Wager;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public interface ISportsBettingService {
    void savePlayer(Player player);
    Player findPlayer();
    List<SportEvent> findAllSportEvents();
    void saveWage(Wager wager);
    List<Wager> findAllWagers();
    void calculateResults();
}