/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.readers;

import ahorcado.turns.Turn;
import ahorcado.words.Word;
import java.io.IOException;

/**
 *
 * @author rnexer
 */
public interface WordReader {

    public Word getWord() throws IOException;
    
}
