package model;

/**
 * @author Patrick Cunfer
 */
public class Tabula {

    private String table;
    private int length;

    public Tabula(String characters){
        // sets the table to characters, and length to the length of characters
        table = characters;
        length = characters.length();
    }


    public char get(char cstart, char coffset){
        // converts chars to ints
        int istart = table.indexOf(cstart);
        int ioffset = table.indexOf(coffset);

        // checks to see if cstart and coffset are in table
        if ((istart >= 0) && (ioffset >= 0)) {

            // initializes idx and simulates an infinite table by wrapping idx
            int idx = istart + ioffset;
            while (idx >= length){
                idx -= length;
            }
            while (idx < 0){
                idx += length;
            }

            return table.charAt(idx);
        } else{
            // placeholder: a character that should never be in a message or a table
            return '\n';
        }
    }
}
