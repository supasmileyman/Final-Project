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
    //Global arraylist for scoring all scores
    public static ArrayList<String> scores = new ArrayList();
    
    /**
     * Allows the user to set a new score in the global arraylist, checks if it meets the 3 character standard.
     * The score is then added to the global scores list, and sorts the list.
     * @param score Score the user had in the course
     */
    public static void setHighScore(int score) {
        boolean lmtchar = false;
        boolean cmplte = false;
        String name = "", output = "", confirm;
        while (!cmplte) {
            lmtchar = false;
            name = JOptionPane.showInputDialog(null, "Enter Your Name (3 Characters)", "AAA");
            name.toUpperCase(); //Put all characters in uppercase
            //Check if name within limits (3 characters)
            if (name.length() != 3) {
                lmtchar = true;
                JOptionPane.showMessageDialog(null, "Illegal Name! Name must be 3 characters.");
            }
            //If the illegal character condition is met, reloop
            if (lmtchar == true) {
                cmplte = false;
            }else { //Otherwise, allow user to get out of loop
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
        //Standardize output
        output = name + " " + score;
        
        //Add output to the global scores arraylist
        scores.add(output);
        //Sort the scores
        sort(scores, 0, scores.size() - 1);
    }
    
    /**
     * Uses a quiksort algorithm to sort all the scores.
     * @param b Arraylist that the algorithm will sort
     * @param l Lower index to search from
     * @param h Higher index to search from
     */
    public static void sort(ArrayList<String> b, int l, int h) {
        int[] a = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            a[i] = Integer.parseInt(b.get(i).substring(4));
        } //Converts the arraylist into an array of just scores, removes names
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
    
    /**
     * Swap method for quiksort algorithm.
     * @param a Int array to swap
     * @param b First index to swap
     * @param c Second index to swap
     * @param d ArrayList to swap
     */
    public static void swap(int[] a, int b, int c, ArrayList<String> d) {
        int t = a[b];
        a[b] = a[c];
        a[c] = t;
        
        String s = d.get(b);
        d.set(b, d.get(c));
        d.set(c, s);
    }
    
    /**
     * Searches through all the scores to find any scores a user has left.
     * @param score Score the user had in the course
     */
    public static void searchScores() {
        //Get name to search for
        String in = JOptionPane.showInputDialog(null, "Enter The 3-Digit Username You Would Like To Search.", "AAA");
        String output;
        int x;
        //Linear search through all score entries
        for (int i = 0; i < scores.size(); i++) {
            if (in.equalsIgnoreCase(scores.get(i).substring(0,3))) {
               x++;
               output += "\nScore: " + scores.get(i).substring(4);
               //Add all scores if user was found
            }
            if (x == 0) {
                //Output no results found string if user could not be found
                output = "\nNo results found."
            }
        }
        //Output to user
        JOptionPane.showMessageDialog(null, "Player " + in + " was found " + x + " times. Scores listed below:" + output);
    }
    
    /**
     * Sorts all entries, then return lowest score.
     * @return Best score in the game
     */
    public static String getHighScore() {
        sort(scores, 0, scores.size() - 1);
        return scores.get(0);
    }
    
    /**
     * Sorts all entries, then return all scores.
     * @return ArrayList containing all names and their respective scores.
     */
    public static ArrayList getAllScores() {
        sort(scores, 0, scores.size() - 1);
        return scores;
    }
    
    /**
     * Loads all scores containined in the scores file.
     */
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
    
    /**
     * Saves all scores currently contained in the scores ArrayList.
     */
    public static void save () {
        load();
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
