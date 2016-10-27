/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.words;

/**
 *
 * @author kenystev
 */
public class Word {
    String name;
    boolean filled[];

    public Word(String name) {
        this.name = name;
        this.filled = new boolean[name.length()];
        
        for(int i = 0; i < name.length(); i++){
            filled[i] = false;
        }
    }

    public boolean match(char nextChar) {
        boolean match = false;
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) == nextChar){
                match = true;
                filled[i] = true;
            }
        }
        return match;
    }

    public boolean isNotCompleted() {
        for(int i = 0; i < name.length(); i++){
            if(filled[i] == false)
                return true;
        }
        return false;
    }

    public boolean isCompleted() {
        return !isNotCompleted();
    }
    
}
