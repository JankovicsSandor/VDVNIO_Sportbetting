/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportbetting;

import database.BetBuilder;
import database.Database;
import database.OutcomeBuilder;
import database.SporteventBuilder;
import domain.Bet;
import domain.BetType;
import domain.FootballSportEvent;
import domain.Outcome;
import exception.TerminateAppExcpetion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        sportsBettingService = service;
        view = view;
        database = new Database();
    }

    public void play() throws TerminateAppExcpetion {
        List<Outcome> outcome = new ArrayList<Outcome>();
        outcome.add(
                new OutcomeBuilder()
                .description("1")
                .build()
        );

        outcome.add(
                new OutcomeBuilder()
                .description("3")
                .build()
        );

        outcome.add(
                new OutcomeBuilder()
                .description("Arsenal")
                .build()
        );

        outcome.add(
                new OutcomeBuilder()
                .description("Chelsea")
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

        String fromDate = "2020-01-01 12:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fromDate, formatter);
        FootballSportEvent footballEvent = (FootballSportEvent) new SporteventBuilder().title("Arsenal vs Chelsea")
                .startDate(dateTime)
                .bets(bets)
                .build(1);

    }

    public void doBetting() {
    }

    public void calculateResults() {
    }

    public void printResults() {
    }
}
