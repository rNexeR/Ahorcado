package ahorcado.players;

public class Player {

    private final String name;
    private int complitedWords;

    public Player(String name) {
        this.name = name;
    }

    public void incrementScore(boolean completed){
        if(completed)
            complitedWords++;
    }

    void init() {
        complitedWords=0;
    }
    
}
