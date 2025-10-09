package kyu5;

import java.util.*;

public class SumOfK {


    public static void main(String[] args) {

        //List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        //List<Integer> ts = new ArrayList<>(Arrays.asList(50));
        List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));

        System.out.println( chooseBestSum(230, 3, ts) );
    }


    /**
     * @param t maximum sum of distances, integer >= 0
     * @param k number of towns to visit, k >= 1
     * @param ls list of distances, all distances are positive or zero integers and this list has at least one element
     * @return the "best" sum ie the biggest possible sum of k distances less than or equal to the given limit t, if that sum exists, or otherwise null
     */
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {

        List<List<Integer>> combinations = combinations(ls, k);

        int maxSum = 0;

        for (List<Integer> combo : combinations) {
            //System.out.println(combo);
            int sum = 0;
            for (int x : combo) sum += x;

            if (sum <= t && sum > maxSum)
                maxSum = sum;
        }

        return maxSum == 0 ? null : maxSum;

    }


    public static List<List<Integer>> combinations(List<Integer> list, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(list, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(List<Integer> list, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            current.add(list.get(i));
            backtrack(list, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
