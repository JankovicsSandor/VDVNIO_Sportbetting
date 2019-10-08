/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportbetting;

import service.ISportsBettingService;
import view.IView;

/**
 *
 * @author Sanyi
 */
public class App {

    private ISportsBettingService sportsBettingService;
    private IView view;

    public App(ISportsBettingService service, IView view) {
        sportsBettingService = service;
        view = view;
    }

    public void play() {
    }

    public void doBetting() {
    }

    public void calculateResults() {
    }

    public void printResults() {
    }
}
