/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.maven;

import com.example.sportsbetting.app.App;
import com.epam.training.sportsbetting.config.AppConfig;
import com.example.sportsbetting.database.BetBuilder;
import com.example.sportsbetting.database.OutcomeBuilder;
import com.example.sportsbetting.database.OutcomeOddBuilder;
import com.example.sportsbetting.database.SporteventBuilder;
import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.BetType;
import com.example.sportsbetting.domain.FootballSportEvent;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.language.LanguageService;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Sanyi
 */
public class SportsBetting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SportsBetting.class);

        String language;
        String country;
        if (args.length != 2) {
            language = "en";
            country = "US";
        } else {
            language = args[0];
            country = args[1];
        }
        MessageFormat formatter = new MessageFormat("Set locatization to {0} {1}");
        logger.info(formatter.format(new Object[]{language, country}));
        LanguageService.setLocale(language, country);
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App application = context.getBean((App.class));

            EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
            EntityManager em = emf.createEntityManager();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String validFrom = "2000-01-01 12:00:00";
            LocalDateTime validFromDate = LocalDateTime.parse(validFrom, dateFormatter);
            String validTo = "2020-01-01 12:00:00";

            EntityTransaction tr = em.getTransaction();
            tr.begin();

            LocalDateTime validToDate = LocalDateTime.parse(validTo, dateFormatter);
            List<OutcomeOdd> outcomeOdd = new ArrayList<>();
            outcomeOdd.add(
                    new OutcomeOddBuilder()
                            .value(new BigDecimal(2))
                            .validFrom(validFromDate)
                            .validUntil(validToDate)
                            .build()
            );

            List<OutcomeOdd> outcomeOdd2 = new ArrayList<>();
            outcomeOdd2.add(
                    new OutcomeOddBuilder()
                            .value(new BigDecimal(3))
                            .validFrom(validFromDate)
                            .validUntil(validToDate)
                            .build()
            );

            List<OutcomeOdd> outcomeOdd3 = new ArrayList<>();
            outcomeOdd3.add(
                    new OutcomeOddBuilder()
                            .value(new BigDecimal(2))
                            .validFrom(validFromDate)
                            .validUntil(validToDate)
                            .build()
            );

            List<OutcomeOdd> outcomeOdd4 = new ArrayList<>();
            outcomeOdd4.add(
                    new OutcomeOddBuilder()
                            .value(new BigDecimal(3))
                            .validFrom(validFromDate)
                            .validUntil(validToDate)
                            .build()
            );

            List<Outcome> outcome = new ArrayList<>();
            outcome.add(
                    new OutcomeBuilder()
                            .description("1")
                            .outcomeOdds(outcomeOdd)
                            .build()
            );

            List<Outcome> outcome2 = new ArrayList<>();
            outcome2.add(
                    new OutcomeBuilder()
                            .description("3")
                            .outcomeOdds(outcomeOdd2)
                            .build()
            );

            List<Outcome> outcome3 = new ArrayList<>();
            outcome3.add(
                    new OutcomeBuilder()
                            .description("Arsenal")
                            .outcomeOdds(outcomeOdd3)
                            .build()
            );

            String pattern = LanguageService.getLocaleBundle().getString("playerScoreGoalMessage");
            MessageFormat resultFormatter = new MessageFormat(pattern);
            List<Bet> bets = new ArrayList<>();
            bets.add(
                    new BetBuilder()
                            .description(resultFormatter.format(new Object[]{"Oliver Giroud"}))
                            .type(BetType.PLAYERS_SCORE)
                            .winnerOutcomes(outcome)
                            .build()
            );

            bets.add(
                    new BetBuilder()
                            .description(LanguageService.getLocaleBundle().getString("numberOfScoredGoalsMessage"))
                            .type(BetType.GOALS)
                            .winnerOutcomes(outcome2)
                            .build()
            );
            bets.add(
                    new BetBuilder()
                            .description(LanguageService.getLocaleBundle().getString("winnerBetMessage"))
                            .type(BetType.WINNER)
                            .winnerOutcomes(outcome3)
                            .build()
            );

            String fromDate = "2020-01-01 12:00:00";

            LocalDateTime dateTime = LocalDateTime.parse(fromDate, dateFormatter);

            FootballSportEvent footballEvent = (FootballSportEvent) new SporteventBuilder().title("Arsenal vs Chelsea")
                    .startDate(dateTime)
                    .bets(bets)
                    .build(1);

            em.persist(outcomeOdd);
            em.persist(outcomeOdd2);
            em.persist(outcomeOdd3);
            em.persist(outcomeOdd4);
            em.persist(outcome);
            em.persist(outcome2);
            em.persist(outcome3);
            em.persist(bets);
            em.persist(footballEvent);
            
            tr.commit();
            System.out.println("Event Id: "+footballEvent.getId());
            //this.database.setSportEvent(footballEvent);
            application.play();
        }

    }

}
