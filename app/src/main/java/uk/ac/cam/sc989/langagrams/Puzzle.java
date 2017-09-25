package uk.ac.cam.sc989.langagrams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Simon on 24/09/2017.
 * One of these objects will be used per level
 * A puzzle should store the available letters, as well as the words which will receive credit
 */

public class Puzzle {
    //available letters for making words
    private List<String> letters;
    //accepted words
    private Map<String, Word> words;

    public Puzzle(String letters){
        this.letters = new ArrayList<String>();
        for(int i = 0; i < letters.length(); i++){
            this.letters.add(letters.substring(i, i+1));
        }
    }

    //check if a given word is accepted, and mark it as found if so
    //returns true if the word is valid and this is the first time it has been entered
    public boolean find(String word){
        boolean r = false;
        if (words.keySet().contains(word) ){
            r = words.get(word).find();
        }
        return r;
    }

    public boolean completed(int language){
        switch (language){
            case Dictionary.DUMMY_TEST:
                return true;
        }
        return false;
    }

    public String toString(){
        String s = "";
        for (String l : letters){
            s += l;
        }
        return s;
    }
}
