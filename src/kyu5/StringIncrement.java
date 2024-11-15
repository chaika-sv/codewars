package kyu5;

import java.math.BigInteger;

public class StringIncrement {

    public static void main(String[] args) {
        System.out.println( incrementString("foobar23") );
    }


    public static String incrementString(String str) {

        String reverseStr = new StringBuilder(str).reverse().toString();

        String reverseNum = "";
        for(Character c : reverseStr.toCharArray()) {
            if (c >= '0' && c <= '9') {
                reverseNum += c;
            } else {
                break;
            }
        }

        if (reverseNum.length() == 0) {
            return str + "1";
        } else {

            String srcStr = str.substring(0, str.length()-reverseNum.length());

            char[] reverseNumArr = reverseNum.toCharArray();

            boolean needOne = false;

            for (int i = 0; i < reverseNumArr.length; i++) {
                char c = reverseNumArr[i];
                if (c != '9') {
                    reverseNumArr[i] = (char)('0' + Character.getNumericValue(c) + 1);
                    needOne = false;
                    break;
                } else {
                    reverseNumArr[i] = '0';
                    needOne = true;
                }
            }

            String newReverseNum = new String(reverseNumArr);

            String newNum = new StringBuilder(newReverseNum).reverse().toString();

            if (needOne)
                newNum = "1" + newNum;

            return srcStr + newNum;
        }

    }


}
