package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        squareRoot(10);


        System.out.println(isDoubloon("acdf"));

        System.out.println(canSpell("jdsaw" , "sadwj"));


    }


    public static void squareRoot(double x) {

        double Guess = x / 2.0; // TODO Guess skal være med småt
        double difference = 1;


        while (difference > 0.0001) {
            double OldGuess = Guess; // TODO OldGuess skal være med småt
            Guess = (Guess + x / Guess) / 2.0;
            difference =  Math.abs (Math.abs(OldGuess) -Math.abs(Guess));
            System.out.println(Guess);
        }
    }

    // TODO Lav den lige aLLIGEVE
    public static void gauss(double x , int n) {

        // n can't be one
        for (int i = 0; i < n - 1 ; i++) {
        }



    }


    public static boolean isDoubloon(String s) {
        // DER SKAL IKKE VÆRE -1 
        for (int i = 0; i < s.length() - 1 ; i++) {
            int lastChar;
            int currChar = s.indexOf(i);

            if (i == 0 ) {
                 lastChar = s.indexOf(0);
            } else {
                lastChar = s.indexOf(i - 1);
            }
            if (currChar < lastChar) {
                return  false;
            }
        }
            return true;
    }


    public static boolean canSpell(String tiles, String word) {

        // TODO OBS MED SMÅT
        boolean TileMissing = false;

        List<Character> CTiles = new ArrayList<>();
            // adds all the tiles to a list
        for (int i = 0; i < tiles.length() ; i++) {
            CTiles.add(tiles.charAt(i));
        }
        // Run a for loop for the word we are trying to spell
        for (int i = 0; i < word.length() ; i++) {
            // Hold the letter in the word we are trying to spell up against the tiles we have
            for (int j = 0; j < CTiles.size(); j++) {
                if (word.charAt(i) == CTiles.get(j)) {
                    CTiles.remove(j);
                    TileMissing = false;
                    break;
                } else {
                    TileMissing = true;
                }
            }
            // inside the loop for the word
            // Check if the current letter was found and if not stop and return false
            if (TileMissing) {
                return false;
            }
        }
            return true;
    }






}
