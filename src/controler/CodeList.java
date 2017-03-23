package controler;

import model.CodeType;

import java.util.LinkedList;

/**
 * Created by daniel on 22/03/17.
 */
public class CodeList {
    private static LinkedList<CodeType> ourInstance;

    public static LinkedList<CodeType> List() {
        if (ourInstance == null){
            ourInstance = new LinkedList<>();
            ourInstance.add(new CodeType("Test Code"));
            ourInstance.add(new CodeType("Also Test"));
        }

        return ourInstance;
    }

    private CodeList() {
    }
}
