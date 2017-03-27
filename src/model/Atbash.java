package model;

/**
 * @author Patrick Cunfer
 */
public class Atbash extends CodeType {
    public Atbash() { super("Atbash");}

    @Override
    public String encode(String message, String key) {
        String table = tab.table;
        if (key.length() != 1) {
            throw new RuntimeException("KeyLength");
        }

        // converts key to int and shifts table
        int ikey = table.indexOf(key.charAt(0));
        if (ikey < 0) {
            throw new RuntimeException("KeyNotInTable");
        }
        table = table.substring(ikey) + table.substring(0, ikey);

        // encodes the message
        String encoded = "";
        for (char c : message.toCharArray()) {
            int start = table.indexOf(c) + 1;
            encoded += table.charAt(start);
        }

        return encoded;
    }

    @Override
    public String decode(String message, String key) {
        return encode(message, key);
    }
}
