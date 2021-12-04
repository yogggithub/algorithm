package solutions.p0986_IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class P0986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        /*
         * Solution v1.1: Two Pointer
         *
         * Runtime: 4 ms @ (beats) 38%
         * Memory Usage: 51.8 MB @ (beats) 29.22%
         */
        // if (firstList.length == 0 || secondList.length == 0) {
        //     return new int[][]{};
        // }
        // ArrayList<int[]> list = new ArrayList<>();
        //
        // int i = 0, j = 0;
        // while (i < firstList.length && j < secondList.length) {
        //     int[] first = firstList[i];
        //     int[] second = secondList[j];
        //
        //     // find the overlap
        //     int start = Math.max(first[0], second[0]);
        //     int end = Math.min(first[1], second[1]);
        //
        //     if (end >= start) {
        //         list.add(new int[]{start, end});
        //     }
        //
        //     //update the pointer with smaller end value
        //     if (first[1] == end) {
        //         i++;
        //     }
        //     if (second[1] == end) {
        //         j++;
        //     }
        // }
        //
        // return list.toArray(new int[0][]);

        /*
         * (learn from Internet)
         * Solution v1.2: Optimize
         */
        List<int[]> ans = new ArrayList();
        int f = 0, s = 0;

        while (f < firstList.length && s < secondList.length) {
            int start = Math.max(firstList[f][0], secondList[s][0]);
            int end = Math.min(firstList[f][1], secondList[s][1]);
            if (start <= end) {
                ans.add(new int[]{start, end});
            }

            if (firstList[f][1] < secondList[s][1]) {
                f++;
            } else {
                s++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
