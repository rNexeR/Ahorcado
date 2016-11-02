package ahorcado.players;

public class Player {

    private final String name;
    private int completedWords;

    public Player(String name) {
        this.name = name;
    }

    public void incrementScore(boolean completed){
        if(completed)
            completedWords++;
    }

    void init() {
        completedWords=0;
    }
    
    public int getCompletedWords() {
        return completedWords;
    }

    @Override
    public String toString() {
        return name;
    }
}
