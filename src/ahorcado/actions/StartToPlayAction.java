/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.actions;

import ahorcado.Game;
import java.io.IOException;

/**
 *
 * @author kenystev
 */
public class StartToPlayAction implements Action {

    public StartToPlayAction() {
    }

    @Override
    public void execute(Game game) throws IOException, Exception {
       game.startToPlay();
    }
    
}
