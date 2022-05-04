package com.example.wordle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WGame
{
    private final int MAX_GUESS = 6; // maximum number of guesses a user can make
    private int numGuesses; // number of guesses a user has made
    private String word; // the 5 letter word to be guessed
    private boolean GameWin; // whether the user has won the game

    /*
    Create a list to store the result from every guess
    Each result in the is a Map in the following format:
      {"THE LETTER IN THE WORD",RESULTCODE}
        RESULTCODE:
            0: the letter is not in the word
            1: the letter is in the word, but not in the correct position
            2: the letter is in the word, and in the correct position
     */

    private List<List> resultList = new ArrayList<List>();

    private void generateGuessResult(String guess)
    {
        //This method will check and compare the guess to the word
        //and generate the result for each guess
        //The result will be stored in the resultList
        //The result will be in the following format:

        //{"THE LETTER IN THE WORD",RESULTCODE}
        //RESULTCODE:

        //0: the letter is not in the word
        //1: the letter is in the word, but not in the correct position
        //2: the letter is in the word, and in the correct position

        //Create a list of String Arrays to store the result for each guess
        List<String[]> result = new ArrayList<String[]>();



        //For each leeter in the guess
        for (int i = 0; i < guess.length(); i++)
        {
            //Get the letter in the guess
            char letter = guess.charAt(i);

            String[] letMap  = new String[2];

            //Check if the letter is in the word
            if (word.indexOf(letter) != -1)
            {
                //Check if the letter is in the correct position
                if (word.indexOf(letter) == i)
                {
                    //Add the result to the resultList
                    letMap[0] = letter + "";
                    letMap[1] = 2 + "";

                }
                else
                {
                    //Add the result to the resultList
                    letMap[0] = letter + "";
                    letMap[1] = 1 + "";
                }
            }
            else
            {
                //Add the result to the resultList
                letMap[0] = letter + "";
                letMap[1] = 0 + "";

            }

            result.add(letMap);
        }

        //Add the result to the list.
        resultList.add(result);



    }
    
    public List<List> getResultList()
    {
        return resultList;
    }

    //A new game is created with a word to be guessed
    WGame(String word)
    {
        this.word = word.toLowerCase();
        numGuesses = 0; // initialize number of guesses to 0
        GameWin = false; // initialize isGameWin to false
    }

    public int getnumGuesses()
    {
        return numGuesses;
    }
    
    public boolean isGameOver()
    {
        return numGuesses >= MAX_GUESS;
    }

    public boolean isGameWon()
    {
        return GameWin;
    }

    public boolean isValidWord(String guess)
    {
        //Will check if the guess is valid (Must be 5 letters)
        return guess.length() == 5;
    }
  

    public void guess(String guess)
    {
        // if the guess is not a valid word, throw an exception
        if (!isValidWord(guess))
            throw new IllegalArgumentException("Invalid word");
        
            // if the guess is a valid guess, increment the number of guesses
        numGuesses++;

        if(guess.equals(word))
        {
            GameWin = true;
            return;
        }

        // generate the result for the guess
        generateGuessResult(guess);

    }

    //This method is only for testing purposes. It is useful to test the functionality of the program and the WGame class. 
    public static void main(String[] args) {

        WGame current = new WGame("Hello");

        while (!current.isGameOver() && !current.isGameWon()) {
            System.out.println("Guess a Word ");
            String guessWord = System.console().readLine();
            try{
                current.guess(guessWord);
            }
            catch(IllegalArgumentException e){
                System.out.println("Invalid word");
            }

            System.out.println("Current Number of Guesses: " + current.getnumGuesses());

         
            //Print the result for each guess
            for (List result : current.getResultList()) {

               for(int i = 0; i < result.size(); i++)
               {
                    String[] resultArray = (String[]) result.get(i);
                    System.out.print(" "+resultArray[1]+"");
               }
               System.out.println(" ");

               for(int i = 0; i < result.size(); i++)
               {
                    String[] resultArray = (String[]) result.get(i);
                    System.out.print(" "+resultArray[0]+"");
               }
               System.out.println(" ");
                
            }

        }

        if(current.isGameWon())
            System.out.println("You win the game in " + current.getnumGuesses() + " guesses");
        else
            System.out.println("You lose");
    }

};
