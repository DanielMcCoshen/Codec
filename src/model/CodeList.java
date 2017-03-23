package model;

import model.CodeType;

import java.util.HashMap;


/**
 * A Singleton-esque class to store the list of codes available in the program
 * @author SigMa (Daniel McCoshen)
 */
public class CodeList {
    private static HashMap<String, CodeType> ourInstance;

    /**
     * gets the static instance of the HashMap storing the available codes
     * @return the HashMap of codes
     */
    public static HashMap<String, CodeType> List() {
        if (ourInstance == null){
            ourInstance = new HashMap<>();
            ourInstance.put( "Test Code", new CodeType("Test Code"));
            ourInstance.put( "Also Test", new CodeType("Also Test"));
        }

        return ourInstance;
    }

    /**
     * private constructor for singleton reasons
     */
    private CodeList() {
    }
}