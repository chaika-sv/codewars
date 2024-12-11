package kyu5;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberTrailingZeroes {


    public static void main(String[] args) {
        System.out.println( zeros(14) );
    }


    public static int zeros(int n) {

        int res = 0;
        int factor5 = 5;

        Map<Integer, Integer> map = new LinkedHashMap<>();

        do {
            map.put(factor5, n / factor5);
            factor5 *= 5;
        }
        while (factor5 < n);

        for (var entry : map.entrySet()) {
            res += entry.getValue();
        }

        return res;
    }


}
