package problems.pN0387_FirstUniqueCharacterInString;

import java.util.HashMap;

/*
 * First Unique Character in a String
 * Given a string, find the first non-repeating character
 * in it and return its index. If it doesn't exist, return -1.
 * Examples:
 *      s = "leetcode"
 *      return 0.
 *      s = "loveleetcode"
 *      return 2.
 * */

public class self {
    public static void main(String[] args) {
        String str1 = "leetcode",
                str2 = "loveleetcode";
        System.out.println(firstUniqChar(str1));
        System.out.println(firstUniqChar(str2));

    }

    public static int firstUniqChar(String s) {

        // Approach 1: Brute Force 蛮力....
        // HashSet<Character> hashSet = new HashSet<>();
        // HashMap<Character, Integer> index = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (hashSet.add(c)) {
        //         index.put(c, i);
        //     } else {
        //         index.remove(c);
        //     }
        // }
        // int i = Integer.MAX_VALUE;
        // if (index.isEmpty()) {
        //     i = -1;
        // } else {
        //     for (char c : index.keySet()) {
        //         i = index.get(c) < i ? index.get(c) : i;
        //     }
        // }
        // return i;

        // Runtime: 34 ms, faster than 30.01% of Java online submissions for First Unique Character in a String.
        // Memory Usage: 46.3 MB, less than 25.25% of Java online submissions for First Unique Character in a String.


        // Approach 2: Count Char
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(count.get(c) == 1){
                return  i;
            }
        }
        return -1;

        // Runtime: 45 ms, faster than 21.01% of Java online submissions for First Unique Character in a String.
        // Memory Usage: 52.2 MB, less than 8.27% of Java online submissions for First Unique Character in a String.
    }
}
