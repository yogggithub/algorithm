package solutions.p2300_SuccessfulPairsofSpellsPotions;

import java.util.Arrays;

public class P2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        int m = potions.length;
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long product = (long) spells[i] * potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - left;

        }
        return ans;
    }
}
