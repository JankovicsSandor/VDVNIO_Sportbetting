/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;

/**
 *
 * @author Sanyi
 */
@Entity
public class TennisSportEvent extends SportEvent {

    public TennisSportEvent() {
    }

    public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, Set<Bet> bets, Result result) {
        super(title, startDate, endDate, bets, result);
    }
    
}
