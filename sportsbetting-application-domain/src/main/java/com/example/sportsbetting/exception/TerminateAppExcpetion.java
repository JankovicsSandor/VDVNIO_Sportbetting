/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.exception;

/**
 *
 * @author Sanyi
 */
public class TerminateAppExcpetion extends Exception {

    public TerminateAppExcpetion(String message) {
        super(message);
    }

    public TerminateAppExcpetion() {
         super("");
    }
    
}
