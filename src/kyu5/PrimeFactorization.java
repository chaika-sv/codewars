package kyu5;

public class PrimeFactorization {


    public static void main(String[] args) {
        System.out.println( factors(933555431 ) );
    }


    public static String factors(int n) {
        StringBuilder res = new StringBuilder();
        int power = 0;

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                power++;
                n /= i;
            }
            if (power == 0) {
                continue;
            }
            res.append("(").append(i);
            if (power > 1) {
                res.append("**").append(power);
            }
            res.append(")");
            power = 0;
        }

        if (n != 1) {
            res.append("(").append(n).append(")");
        }

        return res.toString();
    }


}
