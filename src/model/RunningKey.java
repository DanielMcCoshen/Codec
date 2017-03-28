package model;

/**
 * @author Daniel McCoshen
 */
public class RunningKey extends CodeType{
    public RunningKey(){
        super("Running Key Cypher");
    }

    @Override
    public String encode(String message, String key) {
        if (key.length() < message.length()){
            throw new RuntimeException("The key must be at least the length of the message");
        }
        Vigenere subcode = new Vigenere();

        return subcode.encode(message, key);
    }

    @Override
    public String decode(String message, String key) {
        if (key.length() < message.length()){
            throw new RuntimeException("The key must be at least the length of the message");
        }
        Vigenere subcode = new Vigenere();

        return subcode.decode(message, key);
    }
}
