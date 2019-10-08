/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.Bet;
import domain.Currency;
import domain.Outcome;
import domain.OutcomeOdd;
import domain.Player;
import domain.SportEvent;
import domain.Wager;
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

        System.out.println("How much monez do you have(more than 0) ?");
        player.setBalance(new BigDecimal(scanner.nextLine()));

        System.out.println("What is you currency ?");
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
        System.out.println(player.getBalance());
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEventList) {
        int index = 0;
        for (SportEvent sportEvent : sportEventList) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getWinnerOutcome()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        System.out.println(index + "Sport event: " + sportEvent.getTitle()
                                + "(start: " + sportEvent.getStartDate() + "), Bet " + bet.getDescription() + ", Outcome: " + outcome.getBet().getDescription()
                                + ", Actual odd: " + outcomeOdd.getValue() + ", Valid between" + outcomeOdd.getValidFrom() + "and" + outcomeOdd.getValidUntil() + ".");
                    }
                }
            }
        }
    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEventList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal readWagerAmount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printResults(Player player, List<Wager> wagerList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
