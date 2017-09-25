package uk.ac.cam.sc989.langagrams;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Simon on 24/09/2017.
 */

public class Dictionary {
    public static final int ENGLISH = 0;
    public static final int FRENCH = 1;
    public static final int DUMMY_TEST = -1;

    private int language;
    private ArrayList<Word> words;

    public Dictionary(int language){
        this.language = language;
        switch (language){
            case DUMMY_TEST:
                words = new ArrayList<Word>();
                add("Hello");
                add("World");
                break;
            //TODO load others from file I guess or something
        }
    }

    public int getLanguage(){
        return language;
    }

    public boolean contains(String s){
        Word w = new Word(s, language);
        return words.contains(w);
    }

    public boolean contains(Word w){
        return words.contains(w);
    }

    public void add(String s){
        Word w = new Word(s, language);
        words.add(w);
    }

    public void add(Word w){
        if (w.getLanguage() == language){
            words.add(w);
        }
    }

    //Find all the words in a dictionary that can be made from a given bunch of letters
    //TODO actually it's probably better to go through all the combinations and check if they are valid words
    public ArrayList<Word> getAll(String letters){
        //TODO parallelise
        ArrayList<Word> result = new ArrayList<>();
        for (Word w : words){
            if (w.canBeMadeFrom(letters)){
                result.add(w);
            }
        }
        return result;
    }
}
