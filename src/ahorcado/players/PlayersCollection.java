/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.players;

import java.util.ArrayList;

/**
 *
 * @author rnexer
 */
public interface PlayersCollection {

    void init();

    public int getCount();

    public void push(Player player);
    
    public Player getPlayerI(int index);

}
