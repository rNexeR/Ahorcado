/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import ahorcado.enums.OPTION_MENU;
import ahorcado.turns.Turn;
import ahorcado.words.Word;
import ahorcado.readers.WordReader;
import ahorcado.players.PlayersCollection;
import ahorcado.players.Player;
import ahorcado.ui.UserOutput;
import ahorcado.ui.UserInput;
import java.util.ArrayList;

/**
 *
 * @author rnexer
 */
public class Game {

    private PlayersCollection players;
    private WordReader reader;
    private Turn turn;
    private Word currentWord;
    private boolean exit;
    private int maxFails;
    private UserInput userInput;
    private UserOutput userOutput;
    private int fails;
    private ArrayList<Character> inputChars;
    
    public Game(PlayersCollection players, WordReader reader, UserInput userInput, UserOutput userOutput) {
        this.players = players;
        this.reader = reader;
        this.userInput = userInput;
        this.userOutput = userOutput;
        exit=false;
        this.maxFails=5;
    }
    
    public void setMaxFails(int max_fails){
        this.maxFails = max_fails;
    }

    void init() {
        this.turn = new Turn(players);
    }

    void play() {
        
        do{
            userOutput.showMainMenu();
            OPTION_MENU OPTION = userInput.getMainMenuOptionSelected();

            validateMainOption(OPTION);
        } while(!exit);
    }

    private void waitForLetters() {
        fails = maxFails;
        
        do{
            
            OPTION_MENU OPTION = userInput.getMenuOptionSelected();
            validateCurrentOptions(OPTION);
        } while(fails>0 || currentWord.isNotCompleted());
    }

    private void setWrongLetter(boolean match) {
        if (!match)
            fails--;
    }

    private void startToPlay() {
        Player currentPlayer = turn.getCurrentPlayer();
        //currentWord = reader.getWord(turn);
        waitForLetters();
        currentPlayer.incrementScore(currentWord.isCompleted());
    }

    private void showScore() {
        for (int i = 0; i < players.getCount(); i++) {
            Player currentPlayer = players.getPlayerI(i);
            System.out.println("Player: " + currentPlayer +"has completed " + currentPlayer.getCompletedWords() + "words.");
        }
    }

    private void validateMainOption(OPTION_MENU OPTION) {
        switch(OPTION){
            case PLAY: startToPlay(); break;
            case SCORE: showScore(); break;
            case EXIT: exit=true; break;
            default: userOutput.showErrorMessage("wrong selected option!");
        }
    }

    private void validateCurrentOptions(OPTION_MENU OPTION) {
        switch(OPTION){
            case CONTINUE: getNextCharacter(); break;
            case STATISTICS: showStatistics(); break;
            case EXIT: fails=0; break;
            default: userOutput.showErrorMessage("wrong selected option!");
        }
    }

    private void getNextCharacter() {
        char nextChar = userInput.getNextChar();
        boolean matches = currentWord.match(nextChar);
        setWrongLetter(matches);
        if (matches)
            inputChars.add((Character)nextChar);
    }

    private void showStatistics() {
        for (int i = 0; i < inputChars.size()-1; i++) {
            System.out.println("Current matched letters: " + inputChars.get(i));
        }
        System.out.println("Amount of times failed: " + fails);
    }
    
}
