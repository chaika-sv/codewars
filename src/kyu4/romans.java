package kyu4;

import java.util.Map;

public class romans {


    public static void main (String[] args) {
        System.out.println( fromRoman("MCMXC") );      // 1990
        System.out.println( toRoman(1643) );        // MDCXLIII
    }

    private static final Map<Character, Integer> symbols = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static int fromRoman(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            int cur = symbols.get(s.charAt(i));

            if (i == s.length()-1)
                sum += cur;
            else {
                int next = symbols.get(s.charAt(i+1));
                if (cur >= next)
                    sum += cur;
                else
                    sum -= cur;
            }
        }

        return sum;
    }


    public static String toRoman(int n) {

        int n1000 = n / 1000;
        int n100 = (n % 1000) / 100;
        int n10 = (n % 100) / 10;
        int n1 = n % 10;

        String res = "";

        res += "M".repeat(n1000);
        res += getRomanNum(n100, "C", "D", "M");
        res += getRomanNum(n10, "X", "L", "C");
        res += getRomanNum(n1, "I", "V", "X");

        return res;
    }


    private static String getRomanNum(int n, String cur, String five, String next) {

        return switch (n) {
            case 1, 2, 3 -> cur.repeat(n);
            case 4 -> cur + five;
            case 5, 6, 7, 8 -> five + cur.repeat(n - 5);
            case 9 -> cur + next;
            default -> "";
        };
    }

}
