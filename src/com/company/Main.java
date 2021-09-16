package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        squareRoot(10);

        System.out.println(isAbecedarian("acdf"));

        System.out.println(canSpell("qeykou" , "sadwj"));

        Scanner input = new Scanner(System.in);

        System.out.println("Tjek om ordet er doubloon");

        String s = input.next();

        if (isDoubloon(s)) {
            System.out.println("Ordet " + s + " er doubloon");
        } else {
            System.out.println("Ordet " + s + " er ikke doubloon");
        }

    }


    public static void squareRoot(double x) {

        double guess = x / 2.0;
        double difference = 1;


        while (difference > 0.0001) {
            double oldGuess = guess;
            guess = (guess + x / guess) / 2.0;
            difference =  Math.abs (Math.abs(oldGuess) -Math.abs(guess));
            System.out.println(guess);
        }
    }

    public static boolean isAbecedarian(String s) {

        s = s.toLowerCase();

        for (int i = 0; i < s.length()  ; i++) {
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

    public static boolean isDoubloon(String s) {

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {

            int count = 0;

            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count != 2) {
                return false;
            }
        }
    return true;
    }



    public static boolean canSpell(String tiles, String word) {

        tiles = tiles.toLowerCase();

        boolean tileMissing = false;

        List<Character> cTiles = new ArrayList<>();
            // adds all the tiles to a list
        for (int i = 0; i < tiles.length() ; i++) {
            cTiles.add(tiles.charAt(i));
        }
        // Run a for loop for the word we are trying to spell
        for (int i = 0; i < word.length() ; i++) {
            // Hold the letter in the word we are trying to spell up against the tiles we have
            for (int j = 0; j < cTiles.size(); j++) {
                if (word.charAt(i) == cTiles.get(j)) {
                    cTiles.remove(j);
                    tileMissing = false;
                    break;
                } else {
                    tileMissing = true;
                }
            }
            // inside the loop for the word
            // Check if the current letter was found and if not stop and return false
            if (tileMissing) {
                return false;
            }
        }
            return true;
    }






}
