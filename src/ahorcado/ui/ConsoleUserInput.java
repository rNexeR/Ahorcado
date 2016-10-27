/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.ui;

import ahorcado.enums.OPTION_MENU;
import java.util.Scanner;


/**
 *
 * @author kenystev
 */
public class ConsoleUserInput implements UserInput {

    public Scanner keyboardReader = new Scanner(System.in);
    public String word;
    
    @Override
    public void readWord() {
        word = keyboardReader.nextLine();
    }
    
    @Override
    public String getWord() {
        return word;
    }
    
    @Override
    public char getNextChar() {
        char c = keyboardReader.next().charAt(0);
        return c;
    }


    @Override
    public OPTION_MENU getMainMenuOptionSelected() {
        char c = keyboardReader.next().charAt(0);
        switch (c) {
            case 'a': return OPTION_MENU.PLAY;
            case 'b': return OPTION_MENU.SCORE;
            case 'c': return OPTION_MENU.EXIT;
        }
        return OPTION_MENU.NONE;
    }

    @Override
    public OPTION_MENU getMenuOptionSelected() {
        char c = keyboardReader.next().charAt(0);
        switch (c) {
            case 'a': return OPTION_MENU.CONTINUE;
            case 'b': return OPTION_MENU.STATISTICS;
            case 'c': return OPTION_MENU.EXIT;
        }
        return OPTION_MENU.NONE;
    }
    
}
