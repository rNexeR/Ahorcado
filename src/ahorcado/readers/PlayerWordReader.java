/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.readers;

import ahorcado.turns.Turn;
import ahorcado.ui.UserInput;
import ahorcado.words.Word;
import java.io.IOException;

/**
 *
 * @author Jose34mp
 */
public class PlayerWordReader implements WordReader{
    private UserInput word;
    
    public PlayerWordReader(UserInput word){
        this.word = word;
    }

    @Override
    public Word getWord(Turn turn) throws IOException {
    return new Word(this.word.getWord());}
}
