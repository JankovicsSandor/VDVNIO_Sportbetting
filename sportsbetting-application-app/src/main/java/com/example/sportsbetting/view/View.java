/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.view;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.exception.TerminateAppExcpetion;
import com.example.sportsbetting.language.LanguageService;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sanyi
 */
public class View implements IView {

    @Autowired
    LanguageService service;

    @Override
    public Player readPlayerData() {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        System.out.println(LanguageService.getLocaleBundle().getString("nameAsk"));
        player.setName(scanner.nextLine());

        System.out.println(LanguageService.getLocaleBundle().getString("moneyAsk"));
        player.setBalance(new BigDecimal(scanner.nextLine()));

        System.out.println(LanguageService.getLocaleBundle().getString("currencyAsk"));
        player.setCurrency(Currency.valueOf(scanner.nextLine()));

        return player;
    }

    ;
    
    @Override
    public void printWelcomeMessage(Player player) {
        String pattern = LanguageService.getLocaleBundle().getString("welcomeMessage");
        MessageFormat formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{player.getName()}));
    }

    @Override
    public void printBalance(Player player) {
        String pattern = LanguageService.getLocaleBundle().getString("balanceMessage");
        MessageFormat formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{player.getBalance(), player.getCurrency()}));
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEventList) {
        System.out.println(LanguageService.getLocaleBundle().getString("betAsk"));

        String pattern = LanguageService.getLocaleBundle().getString("betDescription");
        MessageFormat formatter = new MessageFormat(pattern);

        int index = 0;
        for (SportEvent sportEvent : sportEventList) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getWinnerOutcome()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        System.out.println(formatter.format(
                                new Object[]{index, sportEvent.getTitle(), sportEvent.getStartDate(),
                                    bet.getDescription(), outcome.getDescription(), outcomeOdd.getValue(),
                                    outcomeOdd.getValidFrom(), outcomeOdd.getValidUntil()}));
                    }
                }
            }
        }
    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEventList) throws TerminateAppExcpetion {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if ("q".equals(line)) {
            throw new TerminateAppExcpetion();
        }
        int index = 0;
        int choosen = Integer.parseInt(line);
        for (SportEvent sportEvent : sportEventList) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getWinnerOutcome()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        if (index == choosen) {
                            return outcomeOdd;
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public BigDecimal readWagerAmount() {
        System.out.println(LanguageService.getLocaleBundle().getString("betAmountAsk"));
        Scanner scanner = new Scanner(System.in);
        return new BigDecimal(scanner.nextLine());
    }

    @Override
    public void printNotEnoughBalance(Player player) {

        String pattern = LanguageService.getLocaleBundle().getString("notEnoughBalance");
        MessageFormat formatter = new MessageFormat(pattern);
        System.out.println(formatter.format(new Object[]{player.getBalance(), player.getCurrency()}));
    }

    @Override
    public void printResults(Player player, List<Wager> wagerList) {
        String pattern = LanguageService.getLocaleBundle().getString("resultMesage");
        MessageFormat formatter = new MessageFormat(pattern);

        for (Wager wager : wagerList) {
            System.out.println(formatter.format(new Object[]{wager.getOdd().getOutcome().getDescription(),
                wager.getOdd().getOutcome().getBet().getEvent().getTitle(), wager.getOdd().getValue(), wager.getAmount(), wager.isWin()}));
        }

        String pattern2 = LanguageService.getLocaleBundle().getString("newBalanceMessage");
        MessageFormat formatter2 = new MessageFormat(pattern2);

        System.out.println(formatter2.format(new Object[]{player.getBalance(), player.getCurrency()}));
    }

    @Override
    public void printWageSaved(Wager wager) {

        String pattern = LanguageService.getLocaleBundle().getString("betSaveMessage");
        MessageFormat formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{
            wager.getOdd().getOutcome().getBet().getDescription(),
            wager.getOdd().getOutcome().getDescription(),
            wager.getOdd().getOutcome().getBet().getEvent().getTitle(),
            wager.getOdd().getValue(),
            wager.getAmount()}));

    }

}
