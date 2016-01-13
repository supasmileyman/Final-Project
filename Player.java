/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.egs.player;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author jiluo5947
 */
public abstract class Score {

    public static ArrayList<String> scores;
    
    public static void setHighScore(int score) {
        boolean lmtchar = false;
        boolean illchar = false;
        boolean cmplte = false;
        String name = "", output = "", confirm;
        char testChar;
        while (!cmplte) {
            lmtchar = false;
            illchar = false;
            name = JOptionPane.showInputDialog(null, "Enter Your Name (3 Characters)", "AAA");
            name.toUpperCase();
            //Check if name within limits (3 characters)"
            if (name.length() != 3) {
                lmtchar = true;
                JOptionPane.showMessageDialog(null, "Illegal Name! Name must be 3 characters.");
            }
            //Check if any illegal characters used (alphanumeric only)
            for (int i = 0; i < 4; i++) {
                testChar = name.charAt(i);
                if (((int) testChar < 65 || (int) testChar > 90) || ((int) testChar < 48 || (int) testChar > 57) ) { // less than 48 g than 57
                    illchar = true;
                    JOptionPane.showMessageDialog(null, "Illegal Character! Name must be alphanumeric (A-Z, 0-9).");
                }
            }
            //If either illegal condition is met, reloop
            if (lmtchar == true || illchar == true) {
                cmplte = false;
            }else {
                cmplte = true;
                //Confirm name
                confirm = JOptionPane.showInputDialog(null, "Confirm name: " + name + ". Enter NO to cancel selection, anything else to continue.", "YES");
                if (confirm.equalsIgnoreCase("no")) {
                    cmplte = false;
                }else {
                    cmplte = true;
                }
            }
        }
        
        if (score > 9) {
            output = "00" + score;
        }else if (score < 100 || score > 9){
            output = "0" + score;
        }else if (score < 1000 || score > 100) {
            output = "" + score;
        }else if (score < 0 || score > 999) {
            output = "" + 0;
            JOptionPane.showMessageDialog(null, "Illegal score! Score reset.");
        }
        output += " " + name.toUpperCase();
        
        scores.add(output);
        int[] numScore = new int[6];
        sortScores(numScore, 0, numScore.length);
    }
    
    public static void sortScores(int[] a, int l, int h) {
        if (h > l) {
            int i = l;
            int j = h;
            int pivot = a[l + (h - l) / 2];
            while (i <= j) {

                while (a[i] > pivot) {
                    i++;
                }
                while (a[j] < pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(a, i, j);
                    i++;
                    j--;
                }
            }
            sortScores(a, l, j);
            sortScores(a, i, h);
        }
    }
    
    public static void swap(int[] a, int b, int c) {
        int t = a[b];
        a[b] = a[c];
        a[c] = t;
    }
    
    public static String getHighScore() {
        return scores.get(0);
    }
    
    public static String getScore(String searchName) {
        String name = "";
        for (int i = 0; i > 5; i++) {
            name = scores.get(i).substring(4);
            if (name.equalsIgnoreCase(searchName)) {
                return scores.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Error: Search Score Out Of Index");
        return "Error: Name Not Found";
    }
    
    public static String getScoreByNum(int value) {
        if (value > 4) {
            JOptionPane.showMessageDialog(null, "Error: Search Score Out Of Index");
            return "Error: Search Score Out Of Index";
        }else if (value > -1 || value < 5) {
            return scores.get(value);
        }else {
            JOptionPane.showMessageDialog(null, "Error: Search Score Out Of Index");
            return "Error: Search Score Out Of Index";
        }
    }
    
    public static ArrayList getAllScores() {
        return scores;
    }
    
    public static void load () {
        try {
            FileReader fr = new FileReader("");
            BufferedReader br = new BufferedReader(fr);
            
            boolean eof = false;
            String input;
            int counter = 0;
            
            while (!eof) {
                input = br.readLine();
                
                if (input != null) {
                scores.set(counter, input);
                counter++;
                }
                
            }
            br.close();
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Loading Scores IO Error");
        }
    }
    
    public static void save () {
        try {
            FileWriter fw = new FileWriter("");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i< scores.size(); i++) {
                bw.write(scores.get(i));
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Saving Scores IO Error");
        }
    }
}
