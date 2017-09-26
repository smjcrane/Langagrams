package uk.ac.cam.sc989.langagrams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**Created on 25/09/2017 by Simon Crane
 * Unit tests for the Word class
 */
public class WordUnitTest {
    private Word w;

    @Before
    public void setUp(){
        w = new Word("hello");
    }

    @Test
    public void wordsAreCreatedUppercase() throws Exception {
        w = new Word("a");
        assertEquals("A", w.getValue());
    }

    @Test
    public void wordsAreEnglishByDefault() throws Exception {
        assertEquals(w.getLanguage(), Dictionary.ENGLISH);
    }

    @Test
    public void wordsAreNotFoundByDefault() throws Exception {
        assertEquals(w.isFound(), false);
    }

    @Test
    public void wordsCanBeCreatedFrench() throws Exception {
        Word w = new Word("bonjour", Dictionary.FRENCH);
        assertEquals(w.getLanguage(), Dictionary.FRENCH);
    }

    @Test
    public void wordsCanBeCreatedFound() throws Exception {
        Word w = new Word("hello", true);
        Word v = new Word("bonjour", Dictionary.FRENCH, true);
        assertEquals(w.isFound(), true);
        assertEquals(v.isFound(), true);
    }

    @Test
    public void wordsCanBeFoundAfterCreation() throws Exception {
        assertEquals(w.isFound(), false);
        w.find();
        assertEquals(w.isFound(), true);
    }

    @Test
    //IMPORTANT!
    //.equals() method is called from first argument of assertEquals
    //Must test w, "hello" NOT "hello", w
    public void wordIsEqualToLowerCaseString() throws Exception {
        assertEquals(w, "hello");
    }

    @Test
    //IMPORTANT!
    //See above
    public void wordIsEqualToUpperCaseString() throws Exception {
        assertEquals(w, "HELLO");
    }

    @Test
    public void wordIsEqualToSelf() throws Exception {
        assertEquals(w, w);
    }

    @Test
    public void wordIsEqualToWordInOtherCase() throws Exception {
        Word upper = new Word("HELLO");
        assertEquals(w, upper);
    }

    @Test
    public void aIsNotEqualToB() throws Exception {
        Word a = new Word("a");
        Word b = new Word("b");
        assertNotEquals(a, b);
    }

    @Test
    public void sameWordInDifferentLanguagesNotEqual() throws Exception {
        Word eng = new Word("tour", Dictionary.ENGLISH);
        Word fr = new Word("tour", Dictionary.FRENCH);
        assertNotEquals(eng, fr);
    }

    @Test
    public void wordCanMakeItself() throws Exception {
        assertEquals(w.canBeMadeFrom(w.getValue()), true);
    }

    @Test
    public void wordCanBeMadeFromLowerCaseString() throws Exception {
        assertEquals(w.canBeMadeFrom("hello"), true);
    }

    @Test
    public void wordCanBeMadeFromUpperCaseString() throws Exception {
        assertEquals(w.canBeMadeFrom("HELLO"), true);
    }

    @Test
    public void wordCanBeMadeFromAnagram() throws Exception {
        assertEquals(w.canBeMadeFrom("loelh"), true);
        assertEquals(w.canBeMadeFrom("olleh"), true);
    }

    @Test
    public void wordCanBeMadeFromCorrectThing() throws Exception {
        assertEquals(w.canBeMadeFrom("helloworld"), true);
        assertEquals(w.canBeMadeFrom("abcdefghijklmnopqrstuvwxyzl"), true);
    }

    @Test
    public void wordCantBeMadeFromIncorrectThing() throws Exception {
        assertEquals(w.canBeMadeFrom("world"), false);
        assertEquals(w.canBeMadeFrom(""), false);
        assertEquals(w.canBeMadeFrom("foobar"), false);
    }

    @Test
    public void wordCantBeMadeWithoutRepeatsOfRepeatingLetters() throws Exception {
        assertEquals(w.canBeMadeFrom("helo"), false);
    }

    @Test
    public void anagramsWork() {
        Word v = new Word("ab");
        ArrayList a = v.getAnagrams();
        assertEquals(a.contains("AB"), true);
        assertEquals(a.contains("BA"), true);
        assertEquals(a.contains("AA"), false);
        assertEquals(a.contains("BB"), false);
    }
}