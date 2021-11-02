package top_interview_questions.medium.arrays_strings;

import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
    /*
     * Paid problem
     * Not been tested
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();

        int left = lower;
        for (int n : nums) {
            // missing more than one number
            // need to add a cap
            if (n - left > 1) {
                result.add(left + "->" + (n - 1));
            // missing only one number
            // just add that number
            } else if (n - left == 1) {
                result.add(left + "");
            }
            // cut out to speed up and avoid boundary issue
            if (n == upper) {
                return result;
            }
            left = n + 1;
        }

        if (upper - left > 0 ) {
            result.add(left + "->" + upper);
        } else if (upper == left) {
            result.add(upper + "");
        }

        return result;
    }
}
