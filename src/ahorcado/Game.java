/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import ahorcado.actions.ActionFactory;
import ahorcado.actions.OptionNoValidException;
import ahorcado.actions.Action;
import ahorcado.enums.OPTION_MENU;
import ahorcado.turns.Turn;
import ahorcado.words.Word;
import ahorcado.readers.WordReader;
import ahorcado.players.PlayersCollection;
import ahorcado.players.Player;
import ahorcado.ui.UserOutput;
import ahorcado.ui.UserInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ArrayList<Character> inputChars = new ArrayList<>();
    
    public Game(PlayersCollection players, WordReader reader, 
            UserInput userInput, UserOutput userOutput) {
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
        players.init();
        this.turn = new Turn(players);
        turn.randomTurn();
    }

    void play() throws IOException, Exception {
        
        do{
            userOutput.showMainMenu();
            OPTION_MENU OPTION = userInput.getMainMenuOptionSelected();

            executeMainOption(OPTION);
        } while(!exit);
    }

    private void tryToGuessWord() throws Exception {
        fails = maxFails;
        do{ 
            userOutput.showMenu();
            OPTION_MENU OPTION = userInput.getMenuOptionSelected();
            executeCurrentOptions(OPTION);
            if (!currentWord.isNotCompleted())
                userOutput.showMessage("You Won!");
        } while(fails>0 && currentWord.isNotCompleted());
    }

    private void setWrongLetter(boolean match) {
        if (!match)
            fails--;
    }

    public void startToPlay() throws IOException, Exception {
        Player currentPlayer = turn.getCurrentPlayer();
        userOutput.showMessage("Insert word to guess: ");
        currentWord = reader.getWord();
        tryToGuessWord();
        currentPlayer.incrementScore(currentWord.isCompleted());
    }

    public void showScore() {
        for (int i = 0; i < players.getCount(); i++) {
            Player currentPlayer = players.getPlayer(i);
            userOutput.showMessage("Player: " + currentPlayer +" has completed " + 
                    currentPlayer.getCompletedWords() + " words.");
        }
    }
    //Open/Close
    private void executeMainOption(OPTION_MENU OPTION) throws IOException, Exception {
        Action mainAction;
        try {
            mainAction = ActionFactory.createAction(OPTION);
            mainAction.execute(this);
        } catch (OptionNoValidException ex) {
            userOutput.showErrorMessage("wrong selected option!");
        }
    }

    //Open/Close
    private void executeCurrentOptions(OPTION_MENU OPTION) throws Exception {
        Action mainAction;
        try {
            mainAction = ActionFactory.createAction(OPTION);
            mainAction.execute(this);
        } catch (OptionNoValidException ex) {
            userOutput.showErrorMessage("wrong selected option!");
        }
    }

    public void getNextCharacter() {
        userOutput.showMessage("Try Char: ");
        char nextChar = userInput.getNextChar();
        boolean matches = currentWord.match(nextChar);
        setWrongLetter(matches);
        if (!matches && !inputChars.contains((Character)nextChar))
            inputChars.add((Character)nextChar);
    }

    public void showStatistics() {
        userOutput.showMessage("Word: "+currentWord.showProgress());
        for (int i = 0; i < inputChars.size(); i++) {
            userOutput.showMessage("Current mismatched letters: " + inputChars.get(i));
        }
        userOutput.showMessage("Amount of tries remaining: " + fails);
    }

    public void exit() {
        exit=true;
    }

    public void surrender() {
        fails=0;
    }
    
}
