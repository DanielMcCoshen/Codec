package model;

/**
 * An ancestor class of all code types in the program.
 * Not to be instantiated exept for testing
 *
 * @author SigMa (Daniel McCoshen)
 */
public class CodeType {
    public Tabula tab;

    String name;

    public CodeType(String name){
        this.name = name;
    }

    public String encode(String message, String key){
        return "Encoded Derp" + key;
    }

    public String decode(String message, String key){
        return "Decoded Derp" + key;
    }

    public void setTab(Tabula tab){
        this.tab = tab;
    }

    public String toString(){
        return name;
    }
}
