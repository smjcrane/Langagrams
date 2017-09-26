package uk.ac.cam.sc989.langagrams;

/**
 * Created by Simon on 25/09/2017.
 */

public class Common {
    public Dictionary englishDict = new Dictionary(Dictionary.ENGLISH);
    public Dictionary frenchDict = new Dictionary(Dictionary.FRENCH);
    public Dictionary dummyDict = new Dictionary(Dictionary.DUMMY_TEST);

    public static int factorial(int i){
        int f = 1;
        for (int j = 1; j <= i; j++){
            f *= j;
        }
        return f;
    }
}
