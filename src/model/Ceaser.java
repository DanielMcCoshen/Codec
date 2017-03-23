package model;

/**
 * Created by exalaber on 23/03/17.
 */
public class Ceaser extends CodeType {
    public Ceaser(){
        super("Ceaser Shift");
    }

    public String encode(String message, String key){

        if (key.length() != 1){
            throw new RuntimeException("Key Length");
        }

        String encoded = "";
        for (char c : message.toCharArray()) {
            encoded += tab.get(c, key.charAt(0));
        }

        return encoded;
    }

    public String decode(String message, String key){
        if (key.length() != 1) {
            throw new RuntimeException("Key Length");
        }

        if (key.length() != 1) {
            throw new RuntimeException("Key Length");
        }

        String decoded = "";
        tab.exchange(key.charAt(0));
        for (char c : message.toCharArray()) {
            decoded += tab.get(c, key.charAt(0));
        }

        return decoded;
    }
}
