/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.Player;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class PlayerDao extends GenericDao implements IPlayerDao {

    public void AddPlayer(Player player) {
        entityManager.persist(player);
    }

    public Player GetActualPlayer() {
        List<Player> list = entityManager.createQuery("SELECT p FROM Player p",Player.class).getResultList();
        return list.get(0);
    }

    public void UpdatePlayerBalance(BigDecimal newVal) {
        Player player=this.GetActualPlayer();
        player.setBalance(newVal);
        entityManager.persist(player);
    }

}
