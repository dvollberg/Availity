package com.vollberg.availity;

public class LispNestedChecker { 

    public static void main(String[] args) {
        // assuming args[0] contains the lispCode
        // assuming args[0] is a string of at least length 0, code would need error logic without this assumption
        String lispCode = args[0];
        boolean properlyNested = true;
        int nestLevel = 0;
        int cursor = 0;
        if ( lispCode == null ) {
            System.out.println("No string provided");
            return;
        }
        while (cursor < lispCode.length() ) {
            switch (lispCode.charAt(cursor)) {
                case '(':
                    nestLevel++;
                    break;
                case ')':
                    nestLevel--;
                    break;
                default:

            }
            if ( nestLevel < 0 ) { 
                properlyNested = false;
                break;
            }
            cursor++;
        }
        properlyNested = nestLevel == 0;
        System.out.println("The passed in LISP code is " + (properlyNested  ? "" : "not ") + "properly nested.");
    }
}