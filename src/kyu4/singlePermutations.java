package kyu4;

import java.util.*;

public class singlePermutations {


    public static void main (String[] args) {
        System.out.println( singlePermutations("a") );
    }


    static List<String> singlePermutations(String s) {
        if (s.length() == 1)
            return Arrays.asList(s);

        Set<String> results = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String withoutC = s.substring(0, i) + s.substring(i+1, s.length());

            for (String p : singlePermutations(withoutC)) {
                results.add(c + p);
            }
        }

        return new ArrayList<>(results);
    }

}
