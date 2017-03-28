package model;

/**
 * Created by daniel on 28/03/17.
 */
public class Vigenere extends CodeType {

    public Vigenere(){
        super("Vigenere Cypher");
    }

    @Override
    public String decode(String message, String key) {
        String extededKey = key;
        while (extededKey.length() < message.length()){
            extededKey += key;
        }

        String toRet = "";
        for (int i=0; i < message.length(); i++){
            toRet += tab.get(message.charAt(i), tab.exchange(extededKey.charAt(i)));

        }
        return toRet;

    }

    @Override
    public String encode(String message, String key) {
        String extededKey = key;
        while (extededKey.length() < message.length()){
            extededKey += key;
        }

        String toRet = "";
        for (int i=0; i < message.length(); i++){
            toRet += tab.get(message.charAt(i), extededKey.charAt(i));

        }
        return toRet;

    }
}

