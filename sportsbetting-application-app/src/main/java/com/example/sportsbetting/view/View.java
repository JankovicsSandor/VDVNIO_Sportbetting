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
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sanyi
 */
public class View implements IView {

    @Override
    public Player readPlayerData() {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is you name ?");
        player.setName(scanner.nextLine());

        System.out.println("How much money do you have(more than 0) ?");
        player.setBalance(new BigDecimal(scanner.nextLine()));

        System.out.println("What is you currency (HUF, EUR ,USD) ?");
        player.setCurrency(Currency.valueOf(scanner.nextLine()));

        return player;
    }

    ;
    
    @Override
    public void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName() + "!");
    }

    @Override
    public void printBalance(Player player) {
        System.out.println("Your balance is  " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEventList) {
        System.out.println("What are you want to be on? (choose a number or press q for quit)");
        int index = 0;
        for (SportEvent sportEvent : sportEventList) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getWinnerOutcome()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        System.out.println(index + ": Sport event: " + sportEvent.getTitle()
                                + "(start: " + sportEvent.getStartDate() + "), Bet: " + bet.getDescription() + ", Outcome: " + outcome.getDescription()
                                + ", Actual odd: " + outcomeOdd.getValue() + ", Valid between " + outcomeOdd.getValidFrom()
                                + " and " + outcomeOdd.getValidUntil() + ".");
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
        System.out.println("What amount do you wish to bet on it?");
        Scanner scanner = new Scanner(System.in);
        return new BigDecimal(scanner.nextLine());
    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printResults(Player player, List<Wager> wagerList) {
        for (Wager wager : wagerList) {
            System.out.println("Wager ' " + wager.getOdd().getOutcome().getDescription() + "' of " + wager.getOdd().getOutcome().getBet().getEvent().getTitle()
                    + "[odd: " + wager.getOdd().getValue() + ", amount: " + wager.getAmount() + "] win:" + wager.isWin());
        }
        System.out.println("Your new balance is " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printWageSaved(Wager wager) {
        System.out.println("Wager '" + wager.getOdd().getOutcome().getBet().getDescription() + "="
                + wager.getOdd().getOutcome().getDescription() + " of " + wager.getOdd().getOutcome().getBet().getEvent().getTitle()
                + " [odd: " + wager.getOdd().getValue() + ", amount: " + wager.getAmount() + "] saved");
    }

}