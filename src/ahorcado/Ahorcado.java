/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

/**
 *
 * @author rnexer
 */
public class Ahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlayersCollection players = new PlayersConsoleCollection();
        
        Game game = new Game(players);
        game.init();
        game.start();
    }
    
}