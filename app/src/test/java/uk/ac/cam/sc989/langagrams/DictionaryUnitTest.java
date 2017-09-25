package uk.ac.cam.sc989.langagrams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *Created on 25/09/2017 by Simon Crane
 * Unit test for Dictionary class
 */
public class DictionaryUnitTest {
    private Dictionary d;
    private Word w, h;

    @Before
    public void setUp(){
        d = new Dictionary(Dictionary.DUMMY_TEST);
        w = new Word("Foo", Dictionary.DUMMY_TEST);
        h = new Word("Hello", Dictionary.DUMMY_TEST);
    }

    @Test
    public void dictionaryCreatedWithCorrectLanguage() {
        assertEquals(d.getLanguage(), Dictionary.DUMMY_TEST);
    }

    @Test
    public void dummyCreatedWithCorrectWords() {
        assertEquals(d.contains(h), true);
        assertEquals(d.contains("World"), true);
    }

    @Test
    public void canAddWordsToDictionaryByString() {
        assertEquals(d.contains("Foo"), false);
        d.add("Foo");
        assertEquals(d.contains("Foo"), true);
    }

    @Test
    public void canAddWordsToDictionaryByWord() {
        assertEquals(d.contains(w), false);
        d.add(w);
        assertEquals(d.contains(w), true);
    }

    @Test
    public void canMakeWordsFromLetters() {
        assertEquals(d.getAll("hellow").contains(h), true);
        assertEquals(d.getAll("hubbaloolee").contains((h)), true);
    }

    @Test
    public void cantMakeWordsFromBadLetters() {
        assertEquals(d.getAll("world").contains(h), false);
        assertEquals(d.getAll("helo").contains(h), false);
        assertEquals(d.getAll("helloworld").contains(w), false);
    }
}