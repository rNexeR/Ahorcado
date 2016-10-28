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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rnexer
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game;
        PlayersCollection players = new Players();
        ConsoleUserOutput uo = new ConsoleUserOutput();
        ConsoleUserInput ui = new ConsoleUserInput();
        uo.showMessage("a)-----SP----------");
        uo.showMessage("b)-----MP----------");        
        switch (ui.getNextChar()) {
            case 'a':
                    players.push(new Player("Keny"));
                    FileWordReader fileWordReader = new FileWordReader("hangman.hm");
                    game = new Game(players,fileWordReader,new ConsoleUserInput(), new ConsoleUserOutput());
                    setGame(game);
                    break;
            case 'b':
                    players.push(new Player("P1"));
                    players.push(new Player("P2"));
                    game =  new Game(players, ui, uo);
                    setGame(game);
                    break;    
            default:
                uo.showMessage("Unexpected option!");
        }
    }
    
    static void setGame(Game game) {
                game.init();
        try {
            game.play();
        } catch (IOException ex) {
            System.out.println("Bad file name");
        }
    }
}
