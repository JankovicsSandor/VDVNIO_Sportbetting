/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportbetting;

import database.Database;
import exception.TerminateAppExcpetion;
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
    }

    public void doBetting() {
    }

    public void calculateResults() {
    }

    public void printResults() {
    }
}
