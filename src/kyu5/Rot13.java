package kyu5;

public class Rot13 {


    public static void main(String[] args) {
        System.out.println( rot13("Test" ) );
    }

    public static String rot13(String str) {

        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        char newChar;
        int code;
        int newCode;

        for(char c : chars) {

            code = (int)c;

            // A..M, a..m
            if ((code >= 65 && code <= 77) || (code >= 97 && code <= 109))
                newCode = code + 13;
                // N..Z
            else if ((code >= 78 && code <= 90) || (code >= 110 && code <= 122))
                newCode = code - 13;
            else
                newCode = code;

            newChar = (char) newCode;

            //System.out.println(c + " " + (int)c);
            //System.out.println(newChar + " " + (int)newCode);

            result.append(newChar);
        }

        return result.toString();
    }

}
