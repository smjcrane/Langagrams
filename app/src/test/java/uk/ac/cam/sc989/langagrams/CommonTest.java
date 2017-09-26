package uk.ac.cam.sc989.langagrams;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Simon on 25/09/2017.
 * Unit test for Common class
 */
public class CommonTest {
    @Test
    public void factorialWorks() {
        assertEquals(Common.factorial(1), 1);
        assertEquals(Common.factorial(2), 2);
        assertEquals(Common.factorial(3), 6);
        assertEquals(Common.factorial(4), 24);
    }
}