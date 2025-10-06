package kyu5;

public class LongToIP {


    public static void main(String[] args) {
        System.out.println( longToIP( 2154959208L ) );
    }

    public static String longToIP(long ip) {

        String binary32 = String.format("%32s", Long.toBinaryString(ip)).replace(' ', '0');

        String res =
                (int) Long.parseLong( binary32.substring(0,8), 2) + "." +
                (int) Long.parseLong( binary32.substring(8,16), 2) + "." +
                (int) Long.parseLong( binary32.substring(16,24), 2) + "." +
                (int) Long.parseLong( binary32.substring(24,32), 2);

        return res;
    }


}
