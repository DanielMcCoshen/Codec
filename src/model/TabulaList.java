package model;

import java.util.HashMap;

/**
 * a singleton-esque class for storing tabulas
 * @author SigMa (Daniel McCoshen)
 */
public class TabulaList {
    private static HashMap<String, Tabula> ourInstance;

    /**
     * gets the static instance of the HashMap storing the available codes
     * @return the HashMap of codes
     */
    public static HashMap<String, Tabula> List() {
        if (ourInstance == null){
            ourInstance = new HashMap<>();
            ourInstance.put( "English", new Tabula("English", "abcdefghijklmnopqrstuvwxyz "));
            ourInstance.put("Ukrainian", new Tabula("Ukrainian", "абвгґдеєжзиіїйклмиопрстуфхцчшщюяь "));
        }

        return ourInstance;
    }

    /**
     * private constructor for singleton reasons
     */
    private TabulaList() {
    }
}
