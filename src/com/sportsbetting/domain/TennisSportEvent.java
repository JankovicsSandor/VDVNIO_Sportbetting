/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class TennisSportEvent extends SportEvent {

    public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets, Result result) {
        super(title, startDate, endDate, bets, result);
    }
    
}
