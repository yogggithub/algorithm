package solutions.p0023_MergekSortedLists;

import auxiliary.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
         * Solution v1: Back Track
         *
         * Runtime: 7 ms @ (beats) 34.43%
         * Memory Usage: 43.8 MB @ (beats) 89.84%
         */
        List<Integer> vals = new ArrayList<>();

        for (ListNode nodes : lists) {
            while (nodes != null) {
                vals.add(nodes.val);
                nodes = nodes.next;
            }
        }

        Collections.sort(vals);

        ListNode ans = null;
        for (int i = vals.size() - 1; i >= 0 ; i--) {
            ans = new ListNode(vals.get(i), ans);
        }

        return ans;
    }
}
