/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.view;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.exception.TerminateAppExcpetion;
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
