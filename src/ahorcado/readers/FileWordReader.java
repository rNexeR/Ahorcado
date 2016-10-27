/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.readers;

import ahorcado.turns.Turn;
import ahorcado.words.Word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kenystev
 */
public class FileWordReader implements WordReader{

    private String filename;

    public FileWordReader(String filename) {
        this.filename = filename;
    }

    @Override
    public Word getWord() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        FileReader file = new FileReader(filename);
        BufferedReader fileBuffer = new BufferedReader(file);
        Random rnd = new Random();
        String word;
        
        while ((word = fileBuffer.readLine()) != null) {
            words.add(word);
        }
        
        int posToSend = (int)(rnd.nextDouble() * words.size());
        
        return new Word(words.get(posToSend));
    }
    
}
