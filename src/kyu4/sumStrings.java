package kyu4;


public class sumStrings {

    public static void main(String[] args) {
        System.out.println( sumStrings("123", "456") );
    }


    public static String sumStrings(String a, String b) {

        if (a.length() >= b.length())
            b = "0".repeat(a.length() - b.length()) + b;
        else
            a = "0".repeat(b.length() - a.length()) + a;

        StringBuilder res = new StringBuilder("");
        int s;
        int carry = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            int n1 = Character.getNumericValue(a.charAt(i));
            int n2 = Character.getNumericValue(b.charAt(i));

            if (n1 + n2 + carry <= 9) {
                s = n1 + n2 + carry;
                carry = 0;
            } else {
                s = n1 + n2 + carry - 10;
                carry = 1;
            }

            res.append(s);
        }

        res.append(carry);

        return res.reverse().toString().replaceFirst("^0+", "");
    }

}
