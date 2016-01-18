package com.egs.player;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import com.egs.golfhelpers.AssetLoader;
/**
 *
 * @author jiluo5947
 */
public abstract class Score {

    public static ArrayList<String> scores = new ArrayList();
    
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

        output = name + " " + score;
        
        scores.add(output);
        int[] numScore = new int[scores.size()];
        for (int i = 0; i < scores.size(); i++) {
            numScore[i] = Integer.parseInt(scores.get(i).substring(4));
        }
        sort(scores, 0, scores.size() - 1);
    }
    
    public static void sort(ArrayList<String> b, int l, int h) {
        int[] a = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            a[i] = Integer.parseInt(b.get(i).substring(4));
            System.out.println(a[i]);
        }
        if (h > l) {
            int i = l;
            int j = h;
            int pivot = a[l + (h - l) / 2];
            while (i <= j) {

                while (a[i] < pivot) {
                    i++;
                }
                while (a[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(a, i, j, b);
                    i++;
                    j--;
                }
            }
            sort(b, l, j);
            sort(b, i, h);
        }
    }
    
    public static void swap(int[] a, int b, int c, ArrayList<String> d) {
        int t = a[b];
        a[b] = a[c];
        a[c] = t;
        
        String s = d.get(b);
        d.set(b, d.get(c));
        d.set(c, s);
    }
    
    public static String getHighScore() {
        return scores.get(0);
    }
    
    public static String getScore(String searchName) {
        String name = "";
        for (int i = 0; i < 5; i++) {
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
        sort(scores, 0, scores.size() - 1);
        return scores;
    }
    
    public static void load () {
        scores.clear();
        try {
            Reader r = AssetLoader.score.reader();
            BufferedReader br = new BufferedReader(r);
            
            boolean eof = false;
            String input;
            
            while (!eof) {
                input = br.readLine();
                
                if (input != null) {
                scores.add(input);
                }else {
                    eof = true;
                }
                
            }
            br.close();
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Loading Scores IO Error");
        }
    }
    public static void save () {
        try {
            Writer w = AssetLoader.score.writer(false);
            BufferedWriter bw = new BufferedWriter(w);
            
            for (int i = 0; i < scores.size(); i++) {
                bw.write(scores.get(i));
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Saving Scores IO Error");
            System.out.println(e);
        }
    }

}
