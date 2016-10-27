/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.turns;

import ahorcado.players.PlayersCollection;
import ahorcado.players.Player;
import ahorcado.players.Players;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rnexer
 */
public class Turn {

    private ArrayList <Player> allPlayers;
    private ArrayList<Player> randomList;
    private int turnPlayer;
    public Turn(PlayersCollection players) {
        allPlayers = players.getAllPlayers();
        randomList = new ArrayList<Player>();
        turnPlayer = 0;
        
    }
    public void randomTurn(ArrayList<Player> allPlayers){
        Random rnd = new Random();
        for(int i=0; i<allPlayers.size(); i++){
            int temp = rnd.nextInt() * allPlayers.size();
            if(!ifExist(allPlayers.get(temp))){
                randomList.add(allPlayers.get(temp));
            }
        }
        
    }
    private boolean ifExist(Player player){
        for(int i=0; i<allPlayers.size(); i++){
                if(player==randomList.get(i)){
                    return true;
                }
        }
        return false;
    }
    public void nextTurn(){
        if(turnPlayer<randomList.size()){
            turnPlayer++;
        }else{
            turnPlayer = 0;
        }
        
    }
    public Player getCurrentPlayer() {
        return randomList.get(turnPlayer);
    }
    
}