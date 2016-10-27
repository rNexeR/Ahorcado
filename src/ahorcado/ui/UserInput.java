/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.ui;

import ahorcado.enums.OPTION_MENU;

/**
 *
 * @author kenystev
 */
public interface UserInput {

    public char getNextChar();

    public OPTION_MENU getOptionSelected();
    
    public void readWord();
    
    public String getWord();
    
}
