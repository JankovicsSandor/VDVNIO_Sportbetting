/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.app;

import com.example.sportsbetting.database.Database;
import com.example.sportsbetting.database.WagerBuilder;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.exception.TerminateAppExcpetion;
import com.example.sportsbetting.service.ISportsBettingService;
import com.example.sportsbetting.view.IView;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sanyi
 */
public class App {

    private ISportsBettingService sportsBettingService;
    private IView view;
    private Database database;

    public App(ISportsBettingService service, IView view) {
        this.sportsBettingService = service;
        this.view = view;
        database = new Database();
    }

    public void play() {     
        this.createPlayer();

        Boolean doAgain = true;
        while (doAgain) {
            try {
                this.doBetting();
            } catch (TerminateAppExcpetion ex) {
                doAgain = false;
            }
        }
        this.calculateResults();
        this.printResults();

    }

    private void createPlayer() {
        Player player = this.view.readPlayerData();
        this.sportsBettingService.savePlayer(player);
        this.view.printWelcomeMessage(player);
        this.view.printBalance(player);

    }

    private void doBetting() throws TerminateAppExcpetion {

        this.view.printOutcomeOdds(this.database.getSportEvent());
        OutcomeOdd odd = this.view.selectOutcomeOdd(this.database.getSportEvent());
        this.database.setOutcomeOdd(odd);
        BigDecimal amount = this.view.readWagerAmount();
        Player actualPlayer = this.sportsBettingService.findPlayer();
        if (actualPlayer.getBalance().compareTo(amount) != -1) {
            actualPlayer.setBalance((actualPlayer.getBalance().subtract(amount)));
            Random r = new Random();
            Wager wager = new WagerBuilder()
                    .amount(amount)
                    .currency(actualPlayer.getCurrency())
                    .player(actualPlayer)
                    .odd(odd)
                    .win(r.nextBoolean())
                    .timeStampCreated(LocalDateTime.now())
                    .build();
            this.view.printWageSaved(wager);
            this.database.setWager(wager);
        } else {
            this.view.printNotEnoughBalance(actualPlayer);
        }
    }

    private void calculateResults() {
        List<Wager> wagerList = this.database.getWager();
        Player player = this.sportsBettingService.findPlayer();
        for (Wager wager : wagerList) {
            if (wager.isWin()) {
                BigDecimal val = wager.getOdd().getValue().multiply(wager.getAmount());
                player.setBalance((player.getBalance().add(val)));
            }
        }
    }

    private void printResults() {
        Player player = this.sportsBettingService.findPlayer();
        this.view.printResults(player, this.database.getWager());
    }
}
