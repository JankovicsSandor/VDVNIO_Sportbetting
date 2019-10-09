/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportbetting;

import database.BetBuilder;
import database.Database;
import database.OutcomeBuilder;
import database.OutcomeOddBuilder;
import database.SporteventBuilder;
import database.WagerBuilder;
import domain.Bet;
import domain.BetType;
import domain.FootballSportEvent;
import domain.Outcome;
import domain.OutcomeOdd;
import domain.Player;
import domain.Wager;
import exception.TerminateAppExcpetion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ISportsBettingService;
import view.IView;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String validFrom = "2000-01-01 12:00:00";
        LocalDateTime validFromDate = LocalDateTime.parse(validFrom, formatter);
        String validTo = "2020-01-01 12:00:00";
        LocalDateTime validToDate = LocalDateTime.parse(validTo, formatter);
        List<OutcomeOdd> outcomeOdd = new ArrayList<OutcomeOdd>();
        outcomeOdd.add(
                new OutcomeOddBuilder()
                .value(new BigDecimal(2))
                .validFrom(validFromDate)
                .validUntil(validToDate)
                .build()
        );

        List<OutcomeOdd> outcomeOdd2 = new ArrayList<OutcomeOdd>();
        outcomeOdd2.add(
                new OutcomeOddBuilder()
                .value(new BigDecimal(3))
                .validFrom(validFromDate)
                .validUntil(validToDate)
                .build()
        );

        List<OutcomeOdd> outcomeOdd3 = new ArrayList<OutcomeOdd>();
        outcomeOdd3.add(
                new OutcomeOddBuilder()
                .value(new BigDecimal(2))
                .validFrom(validFromDate)
                .validUntil(validToDate)
                .build()
        );

        List<OutcomeOdd> outcomeOdd4 = new ArrayList<OutcomeOdd>();
        outcomeOdd4.add(
                new OutcomeOddBuilder()
                .value(new BigDecimal(3))
                .validFrom(validFromDate)
                .validUntil(validToDate)
                .build()
        );

        List<Outcome> outcome = new ArrayList<Outcome>();
        outcome.add(
                new OutcomeBuilder()
                .description("1")
                .outcomeOdds(outcomeOdd)
                .build()
        );

        List<Outcome> outcome2 = new ArrayList<Outcome>();
        outcome.add(
                new OutcomeBuilder()
                .description("3")
                .outcomeOdds(outcomeOdd2)
                .build()
        );

        List<Outcome> outcome3 = new ArrayList<Outcome>();
        outcome.add(
                new OutcomeBuilder()
                .description("Arsenal")
                .outcomeOdds(outcomeOdd3)
                .build()
        );

        List<Bet> bets = new ArrayList<Bet>();
        bets.add(
                new BetBuilder()
                .description("player Oliver Giroud score")
                .type(BetType.PLAYERS_SCORE)
                .winnerOutcomes(outcome)
                .build()
        );

        bets.add(
                new BetBuilder()
                .description("number of scored goals")
                .type(BetType.GOALS)
                .winnerOutcomes(outcome2)
                .build()
        );

        bets.add(
                new BetBuilder()
                .description("winner")
                .type(BetType.WINNER)
                .winnerOutcomes(outcome3)
                .build()
        );

        String fromDate = "2020-01-01 12:00:00";

        LocalDateTime dateTime = LocalDateTime.parse(fromDate, formatter);

        FootballSportEvent footballEvent = (FootballSportEvent) new SporteventBuilder().title("Arsenal vs Chelsea")
                .startDate(dateTime)
                .bets(bets)
                .build(1);

        this.database.setSportEvent(footballEvent);
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

    }

    private void doBetting() throws TerminateAppExcpetion {

        this.view.printOutcomeOdds(this.database.getSportEvent());
        OutcomeOdd odd = this.view.selectOutcomeOdd(this.database.getSportEvent());
        this.database.setOutcomeOdd(odd);
        BigDecimal amount = this.view.readWagerAmount();
        Player actualPlayer = this.sportsBettingService.findPlayer();
        if (actualPlayer.getBalance().compareTo(amount) != -1) {
            actualPlayer.setBalance((actualPlayer.getBalance().subtract(amount)));
            Wager wager = new WagerBuilder()
                    .amount(amount)
                    .currency(actualPlayer.getCurrency())
                    .player(actualPlayer)
                    .odd(odd)
                    .timeStampCreated(LocalDateTime.now())
                    .build();
            this.view.printWageSaved(wager);
        } else {
            this.view.printNotEnoughBalance(actualPlayer);
        }
    }

    private void calculateResults() {
    }

    private void printResults() {
    }
}
