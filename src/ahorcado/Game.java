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
public class Game {

    private PlayersCollection players;
    private WordReader reader;
    private Turn turn;
    
    public Game(PlayersCollection players, WordReader reader) {
        this.players = players;
        this.reader = reader;
    }

    void init() {
        this.turn = new Turn(players);
    }

    void start() {
        Player current = turn.getCurrentPlayer();
    }
    
}
