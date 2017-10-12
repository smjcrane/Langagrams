package uk.ac.cam.sc989.langagrams;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Simon on 25/09/2017.
 * Stores basic information about a word
 */

class Word{
    private int language;
    private String value;
    private boolean found;
    private ArrayList<String> letters;

    //By default, a word is considered English, because I say so
    public Word(String s){
        language = Dictionary.ENGLISH;
        value = s.toUpperCase();
        found = false;
        letters = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++){
            letters.add(value.substring(i, i+1));
        }
    }

    //You can specify language at creation time
    public Word(String s, int language){
        this(s);
        this.language = language;
    }

    //If a level is abandoned and later resumed, we want to be able to load a saved state of which
    //words had already been found
    public Word(String s, int language, boolean found){
        this(s, language);
        this.found = true;
    }

    public Word(String s, boolean found){
        this(s);
        this.found = true;
    }

    public int getLanguage(){
        return language;
    }

    public String getValue(){
        return value;
    }

    public boolean isFound(){
        return found;
    }

    //mark a word as found
    public boolean find(){
        if (found==true){
            return false;
        }
        found = true;
        return true;
    }

    //check if another Word or a String is equal to this one
    public boolean equals(Object o){
        if (o instanceof String){
            if (value.equals(((String) o).toUpperCase())){
                return true;
            }
        }
        if (o instanceof Word){
            if (language == ((Word) o).language && value.equals(((Word) o).value)){
                return true;
            }
        }
        return false;
    }

    //check whether we can make this word from the given letters
    public boolean canBeMadeFrom(String letters){
        //Convert to uppercase
        letters = letters.toUpperCase();
        //Work out how many times we need each letter
        HashMap<String, Integer> need = new HashMap<>();
        for (int i = 0; i < value.length(); i++) {
            String l = value.substring(i, i+1);
            if (need.containsKey(l)) {
                need.put(l, need.get(l) + 1);
            } else {
                need.put(l, 1);
            }
        }
        //Work out how many of each letter we have
        HashMap<String, Integer> have = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            String l = letters.substring(i, i+1);
            if (have.containsKey(l)) {
                have.put(l, have.get(l) + 1);
            } else {
                have.put(l, 1);
            }
        }
        //work out if we have enough of each thing we need
        for (String l : need.keySet()){
            if (!have.containsKey(l)){
                return false;
            }
            else if (need.get(l) > have.get(l)) {
                return false;
            }
        }
        //if we survived the above loop, we did have enough
        return true;
    }

    //find all anagrams
    public ArrayList<String> getAnagrams(){
        ArrayList<String> anags = new ArrayList<String>();
        int num = Common.factorial(value.length());
        for (int i = 0; i < num; i++) {
            int k = i;
            String s = "";
            for (int j = 0; j < value.length(); j++){
                if (j == value.length() - 1){
                    s += letters.get(0);
                    letters.remove(0);
                } else {
                    s += letters.get(k % (value.length() - j ));
                    letters.remove(k % (value.length() - j ));
                }
                k /= (j + 1);
            }
            anags.add(s);
            letters = new ArrayList<String>();
            for (int l = 0; l < s.length(); l++){
                letters.add(value.substring(l, l+1));
            }
        }
        return anags;
    }

    public ArrayList<Word> getAnagramsAsWords() {
        //TODO add relevant dictionary checks
        ArrayList<String> stringRams = getAnagrams();
        ArrayList<Word> wordRams = new ArrayList<>();
        for (String s : stringRams) {
            wordRams.add(new Word(s, language));
        }
        return wordRams;
    }

    public ArrayList<Word> getSubWords(){
        ArrayList<Word> subWords = new ArrayList<Word>();
        if (value.length() <= 1){
            return subWords;
        }
        for (int i = 0; i < value.length(); i++) {
            String subValue = value.substring(0,i).concat(value.substring(i+1,value.length()));
            Word subWord = new Word(subValue, language);
            subWords.add(subWord);
            for (Word w : subWord.getSubWords()) {
                subWords.add(w);
            }
        }
        return subWords;
    }
}