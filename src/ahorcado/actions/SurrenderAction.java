/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.actions;

import ahorcado.Game;

/**
 *
 * @author kenystev
 */
public class SurrenderAction implements Action {

    public SurrenderAction() {
    }

    @Override
    public void execute(Game game) throws Exception {
        game.surrender();
    }
    
}
