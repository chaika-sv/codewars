package kyu5;

public class CountIPAddresses  {

    public static void main(String[] args) {

        System.out.println( ipsBetween("10.0.0.0", "10.0.0.50") );

    }

    public static long ipsBetween(String start, String end) {

        String[] startParts = start.split("\\.");
        String[] endParts = end.split("\\.");

        long startNum = (long) Integer.parseInt(startParts[0]) * 256 * 256 * 256 +
                (long) Integer.parseInt(startParts[1]) * 256 * 256 +
                (long) Integer.parseInt(startParts[2]) * 256 +
                Integer.parseInt(startParts[3]);

        long endNum = (long) Integer.parseInt(endParts[0]) * 256 * 256 * 256 +
                (long) Integer.parseInt(endParts[1]) * 256 * 256 +
                (long) Integer.parseInt(endParts[2]) * 256 +
                Integer.parseInt(endParts[3]);

        return endNum - startNum;
    }

}


