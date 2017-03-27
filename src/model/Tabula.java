package model;

/**
 * @author Patrick Cunfer
 */
public class Tabula {

    public String table;
    private int length;

    private String name;

    /**
     * establishes tabula
     * @param name the name of the object
     * @param characters the characters to be included in the tabula
     */
    public Tabula(String name,String characters){
        // sets the table to characters, and length to the length of characters
        table = characters;
        length = characters.length();
        this.name = name;
    }

    /**
     * generates a character of cipher text
     * @param cstart the character of plain text
     * @param coffset teh key character
     * @return the character of cipher text
     */
    public char get(char cstart, char coffset){

        // converts chars to ints
        int istart = table.indexOf(cstart);
        int ioffset = table.indexOf(coffset);

        // checks to see if cstart and coffset are in table
        if (istart == -1) {
            throw new RuntimeException("message not in table");
        } else if (ioffset == -1) {

            throw new RuntimeException("key not in table");

        } else {

            // initializes idx and simulates an infinite table by wrapping idx
            int idx = istart + ioffset;
            while (idx >= length){
                idx -= length;
            }
            while (idx < 0){
                idx += length;
            }

            return table.charAt(idx);
        }
    }

    /**
     * exchanges an encoding key character for a decoding key character
     * @param key the encoding key character
     * @return the decoding key character
     */
    public char exchange(char key){
        // converts to int
        int fkey = table.indexOf(key);

        // checks if key is in table
        if (fkey == -1) {
            throw new RuntimeException("key not in table");
        } else {
            // converts forward key to backward key
            fkey = length -fkey;

            return table.charAt(fkey);
        }
    }

    public String toString(){
        return name;
    }
}
