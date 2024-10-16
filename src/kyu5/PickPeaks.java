package kyu5;

import java.util.*;

public class PickPeaks {

    public static void main(String[] args) {



        Map<String,List<Integer>> res = getPeaks(new int[]{1, 2, 3, 6, 4, 1, 2, 3, 2, 1});

    }

    public static Map<String,List<Integer>> getPeaks(int[] arr) {

        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < arr.length-1; i++) {
            if ((arr[i] > arr[i-1]) && (arr[i] > arr[i+1])) {
                //System.out.printf("%d - %d%n", arr[i], i);
                pos.add(i);
                peaks.add(arr[i]);
            }

            if ((arr[i] > arr[i-1]) && (arr[i] == arr[i+1])) {
                int j = i+1;
                while ((arr[j] == arr[i+1]) && (j < arr.length-1)) {
                    j++;
                }
                if (arr[i] > arr[j]) {
                    //System.out.printf("%d - %d%n", arr[i], i);
                    pos.add(i);
                    peaks.add(arr[i]);
                }
            }

        }

        return new HashMap<String, List<Integer>>() {{
            put("pos", pos);
            put("peaks", peaks);
        }};
    }

}
