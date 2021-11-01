package top_interview_questions.medium.arrays_strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // base case
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 6 ms @ (beats) 86.21%
         * Memory Usage: 42.4 MB @ (beats) 68.90%
         */

        // use a Map to store different Anagrams
        Map<String, List<String>> temp = new HashMap<>();
        for (String s : strs) {
            // sort every strings in given array
            // and put sorted string into temp Map
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            // Map's key set require unique
            // if two strings have same Anagrams
            // they could be categoried by same key
            if (temp.containsKey(key)) {
                temp.get(key).add(s);
                continue;
            }
            ArrayList<String> row = new ArrayList<>();
            row.add(s);
            temp.put(key, row);
        }

        result.addAll(temp.values());
        return result;
    }
}
