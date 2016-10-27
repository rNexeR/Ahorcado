package ahorcado.players;

import java.util.ArrayList;

public class Players implements PlayersCollection {

    private ArrayList<Player> allPlayers;

    public Players() {
        allPlayers = new ArrayList<Player>();
    }

    @Override
    public void init() {
        for (Player player : allPlayers) {
            player.init();
        }
    }

    @Override
    public int getCount() {
        return allPlayers.size();
    }

    @Override
    public void push(Player player) {
        allPlayers.add(player);
    }

    @Override
    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }
}
