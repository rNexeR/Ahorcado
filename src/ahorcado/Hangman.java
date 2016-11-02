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
import ahorcado.readers.PlayerWordReader;
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

    static Game game;
    static PlayersCollection players = new Players();
    static ConsoleUserOutput uo = new ConsoleUserOutput();
    static ConsoleUserInput ui = new ConsoleUserInput();
    
    public static void main(String[] args) {
        setGame();
        playGame();
    }

    static void setGame(){
        uo.showMessage("a) Single Player");
        uo.showMessage("b) Multiplayer");        
        switch (ui.getNextChar()) {
            case 'a':
                players.push(new Player("Keny"));
                game = new Game(players,new FileWordReader("hangman.hm"),ui, uo);
                
                break;
            case 'b':
                players.push(new Player("P1"));
                players.push(new Player("P2"));
                game =  new Game(players, new PlayerWordReader(ui), ui, uo);
                
                break;    
            default:
                uo.showMessage("Unexpected option!");
        }
    }
    
    static void playGame() {
        game.init();
        try {
            game.play();
        } catch (IOException ex) {
            System.out.println("Bad file name");
        } catch (Exception ex) {
            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
