package model;

/**
 * @author Patrick Cunfer
 */
public class Ceaser extends CodeType {
    public Ceaser(){
        super("Ceaser Shift");
    }

    /**
     * encodes a message in Ceaser Shift
     * @param message a string containing the message
     * @param key a key character
     * @return a string containing the encoded message
     */
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

    /**
     * decodes a message in Ceaser Shift
     * @param message a string containing the encoded message
     * @param key a key character
     * @return a string containing the decoded message
     */
    public String decode(String message, String key){
        if (key.length() != 1) {
            throw new RuntimeException("Key Length");
        }

        String decoded = "";
        char k = tab.exchange(key.charAt(0));
        for (char c : message.toCharArray()) {
            decoded += tab.get(c, k);
        }

        return decoded;
    }
}
