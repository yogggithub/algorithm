package solutions.p0017_LetterCombinationsPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0017 {

    public List<String> letterCombinations(String digits) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 79.70%
         * Memory Usage: 41.1 MB @ (beats) 69.15%
         */
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        for (int i = 0; i < digits.length(); i++) {
            ans = buider(new ArrayList<String>(), (int) (digits.charAt(i)));
        }

        return ans;
    }

    public static List<String> buider(List<String> ans, int d) {
        String[][] mp = new String[][]{
                {},
                {},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };

        if (ans == null || ans.size() == 0) {
            return Arrays.asList(mp[d]);
        } else {
            List<String> temp = new ArrayList<>();

            for (String a : ans) {
                for (String s : mp[d]) {
                    temp.add(a.concat(s));
                }
            }
            return temp;
        }
    }
}
