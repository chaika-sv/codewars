package kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interval {

    public static void main(String[] args) {

        //System.out.println( sumIntervals(new int[][]{{6, 10}, {1, 2}, {11, 15}}) );
        System.out.println( sumIntervals(new int[][]{}) );
    }


    public static int sumIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //printIntervals(intervals);

        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMerged =  merged.get(merged.size()-1);

            // current.start <= lastMerged.end
            if (intervals[i][0] <= lastMerged[1])
                // lastMerged.end = max(lastMerged.end, current.end)
                lastMerged[1] = Math.max(lastMerged[1], intervals[i][1]);
            else
                merged.add(intervals[i]);
        }

        int res = 0;
        for (int[] interval : merged)
            res += interval[1] - interval[0];

        return res;
    }

    public static void printIntervals(int[][] intervals) {
        System.out.print("[ ");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(Arrays.toString(intervals[i]));
            if (i < intervals.length - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }

}
