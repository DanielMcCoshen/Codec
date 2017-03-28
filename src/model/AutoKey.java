package model;

/**
 * @author Daniel McCoshen
 */
public class AutoKey extends CodeType {
    public AutoKey(){
        super("Auto Key");
    }

    @Override
    public String encode(String message, String key) {
        String extededkey = key+message;

        Vigenere subcode = new Vigenere();
        return subcode.encode(message, extededkey);
    }

    @Override
    public String decode(String message, String key) {

        String extededkey = key;
        String toRet = "";
        for (int i =0; i < message.length(); i++){
            char decoded = tab.get(message.charAt(i), tab.exchange(extededkey.charAt(i)));
            toRet += decoded;
            extededkey+=decoded;
        }
        return toRet;
    }
}
