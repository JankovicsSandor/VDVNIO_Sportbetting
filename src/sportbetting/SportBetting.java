/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportbetting;

import database.Database;
import exception.TerminateAppExcpetion;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.SportBettingSerivce;
import view.View;

/**
 *
 * @author Sanyi
 */
public class SportBetting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       App app= new App(new SportBettingSerivce(new Database()),new View());
        try {
            app.play();
        } catch (TerminateAppExcpetion ex) {
            System.exit(0);
        }
    }
    
}
