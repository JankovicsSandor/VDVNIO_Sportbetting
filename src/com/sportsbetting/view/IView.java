/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsbetting.view;

import com.sportsbetting.domain.OutcomeOdd;
import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.SportEvent;
import com.sportsbetting.domain.Wager;
import com.sportsbetting.exception.TerminateAppExcpetion;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public interface IView {
   Player readPlayerData();
   void printWelcomeMessage(Player player);
   void printBalance(Player player);
   void printOutcomeOdds(List<SportEvent> sportEventList);
   OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEventList)throws TerminateAppExcpetion;
   BigDecimal readWagerAmount();
   void printWageSaved(Wager wager);
   void printNotEnoughBalance(Player player);
   void printResults(Player player,List<Wager> wagerList);
}
