/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.turns;

import ahorcado.players.PlayersCollection;
import ahorcado.players.Player;
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
    public void randomTurn(){
        Random rnd = new Random();
        int i=0;
        while(i<allPlayers.size()){
            int temp = (int)(rnd.nextDouble() * allPlayers.size()+0);
            if(!ifExist(allPlayers.get(temp))){
                randomList.add(allPlayers.get(temp));
                i++;
            }
        }
    }
    private boolean ifExist(Player player){
        if(randomList.contains(player)){
                    return true;
                }
        return false;
    }
    public void nextTurn(){
        if(turnPlayer<randomList.size()-1){
            turnPlayer++;
        }else{
            turnPlayer = 0;
        }
        
    }
    public Player getCurrentPlayer() {
        return randomList.get(turnPlayer);
}
    
}