/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Sanyi
 */
@Entity
public class FootballSportEvent extends SportEvent {

    public FootballSportEvent() {
    }

    public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets, Result result) {
        super(title, startDate, endDate, bets, result);
    }
    
}
