package problems.$$0387_FirstUniqueCharacterInString;

public class solution {
    public static void main(String[] args) {
        String str1 = "leetcode",
                str2 = "loveleetcode";
        System.out.println(firstUniqChar(str1));
        System.out.println(firstUniqChar(str2));

    }

    public static int firstUniqChar(String s) {

        //  Approach 1: Only use array

        // // declare a array to store the frequency of the char in the string
        // int freq [] = new int[26];
        // // first loop, count the frequency
        // for(int i = 0; i < s.length(); i ++){
        //     // here, cause the array is defined as 26 elements
        //     // so every char should minus a to make the value down to below 26.
        //     freq [s.charAt(i) - 'a'] ++;
        // }
        // // then go through the string again, find the index of the firs unique char.
        // for(int i = 0; i < s.length(); i ++){
        //     if(freq [s.charAt(i) - 'a'] == 1){
        //         return i;
        //     }
        // }
        // return -1;

        // Runtime: 15 ms, faster than 67.23% of Java online submissions for First Unique Character in a String.
        // Memory Usage: 46.1 MB, less than 26.18% of Java online submissions for First Unique Character in a String.

        // Approach 2: two pointers

        // for empty string no unique char
        if (s == null || s.length() == 0) {
            return -1;
        }

        // since s contains only lowercase letters, there are only 26 possible
        // we can keep count of chars encountered
        int[] count = new int[26];

        // use slow and fast pointer, fast to incrementally read char
        // slow to increment if found duplicate character. Slow points to unique char
        int slow = 0;
        int fast = 1;

        // for first char count is 1
        count[s.charAt(slow) - 'a']++;

        // iterate over all chars starting from second char to check if dupe
        while (fast < s.length()) {

            count[s.charAt(fast) - 'a']++;

            // if found a dupe char, increment slow to next unique char
            while (slow < s.length() && count[s.charAt(slow) - 'a'] > 1) {
                slow++;
            }

            // if all chars are dupe, return
            if (slow == s.length()) {
                return -1;
            }

            // if this char is covered first time, reset fast to 1 char ahead
            if (count[s.charAt(slow) - 'a'] == 0) {
                fast = slow + 1;
                count[s.charAt(slow) - 'a']++;
            } else {    // else increment fast to next char
                fast++;
            }
        }
        return slow;

        // Runtime: 6 ms, faster than 92.09% of Java online submissions for First Unique Character in a String.
        // Memory Usage: 40 MB, less than 73.65% of Java online submissions for First Unique Character in a String.
    }
}
