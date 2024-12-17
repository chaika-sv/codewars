package kyu5;

import java.util.HashMap;
import java.util.Map;

public class GreedIsGood {

    private static final Map<Integer, Integer> points3;
    private static final Map<Integer, Integer> points1;
    static {
        points3 = Map.of(1, 1000, 6, 600, 5, 500, 4, 400, 3, 300, 2, 200);
        points1 = Map.of(1, 100, 5, 50, 2, 0, 3, 0, 4, 0, 6, 0);
    }


    public static void main(String[] args) {
        System.out.println( greedy(new int[]{5,1,3,4,1} ) );
    }

    public static int greedy(int[] dice){

        Map<Integer, Integer> map = new HashMap();

        for (int num : dice) {
            map.merge(num, 1, Integer::sum);
        }

        Integer count = 0;
        Integer curCount = 0;

        do {
            curCount = calcCount(map);
            count += curCount;
        }
        while (curCount != 0);

        return count;
    }

    private static Integer calcCount(Map<Integer, Integer> map) {

        Integer count = 0;

        for (var entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                count += points3.get(entry.getKey());
                entry.setValue(entry.getValue() - 3);
            } else if (entry.getValue() > 0) {
                count += points1.get(entry.getKey());
                entry.setValue(entry.getValue() - 1);
            }
        }

        return count;
    }

}
