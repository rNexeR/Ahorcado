/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.actions;

import ahorcado.enums.OPTION_MENU;

/**
 *
 * @author kenystev
 */
public class OptionNoValidException extends Exception {

    public OptionNoValidException(OPTION_MENU OPTION) {
        super(OPTION+"");
    }
    
}
