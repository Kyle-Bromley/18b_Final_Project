/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

/**
 *
 * @author uclak
 */
import java.io.*;
import java.util.ArrayList;
public class Operations implements Serializable{
    private double lastVal;
    private ArrayList<String> calculatorHistory;
    
    public Operations() {
        this.lastVal = 0.0;
        this.calculatorHistory = new ArrayList<String>();
    }
    public Operations(double lastVal) {
        this.lastVal = lastVal;
    }
    public void addOperation(String operation) {
        calculatorHistory.add(operation);
    }
    public String displayHistory() {
        String rs = "";
        for(String s : this.calculatorHistory) {
            rs = rs + s + "\n";
        }
        return rs;
    }
    public void setLastVal(double val) {
        this.lastVal = val;
    }    
}