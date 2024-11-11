package kyu5;

import java.util.List;
import java.util.Map;
import java.math.BigInteger;

public class SumFct {

    public static void main(String[] args) {
        System.out.println( perimeter(BigInteger.valueOf(7)) );
    }

    public static BigInteger perimeter(BigInteger n) {
        BigInteger fibo1 = BigInteger.ONE;
        BigInteger fibo2 = BigInteger.ONE;
        BigInteger fibonacci;
        BigInteger sum = BigInteger.TWO;

        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(n.add(BigInteger.ONE)) <= 0; i = i.add(BigInteger.ONE)) {
            fibonacci = fibo1.add(fibo2);
            fibo1 = fibo2;
            fibo2 = fibonacci;
            sum = sum.add(fibonacci);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

}
