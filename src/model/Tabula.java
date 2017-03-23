package model;

/**
 * @author Patrick Cunfer
 */
public class Tabula {

    private String table;
    private int length;

    private String name;

    public Tabula(String name,String characters){
        // sets the table to characters, and length to the length of characters
        table = characters;
        length = characters.length();
        this.name = name;
    }


    public char get(char cstart, char coffset){
        // converts chars to ints
        int istart = table.indexOf(cstart);
        int ioffset = table.indexOf(coffset);

        // checks to see if cstart and coffset are in table
        if (istart == -1) {
            throw new RuntimeException("cstart not in table");
        } else if (ioffset == -1) {

            throw new RuntimeException("coffset not in table");

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

    public String toString(){
        return name;
    }
}
