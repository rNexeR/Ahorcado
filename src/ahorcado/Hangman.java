/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import ahorcado.players.Player;
import ahorcado.players.PlayersCollection;
import ahorcado.players.Players;
import ahorcado.readers.FileWordReader;
import ahorcado.ui.ConsoleUserOutput;
import ahorcado.ui.ConsoleUserInput;

/**
 *
 * @author rnexer
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlayersCollection players = new Players();
        players.push(new Player("Keny"));
        FileWordReader fileWordReader = new FileWordReader("hangman.hm");
        
        Game game = new Game(players,fileWordReader,new ConsoleUserInput(), new ConsoleUserOutput());
        game.init();
        game.play();
    }
    
}
