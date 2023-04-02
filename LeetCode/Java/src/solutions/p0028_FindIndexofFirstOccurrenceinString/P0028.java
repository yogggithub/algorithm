package solutions.p0028_FindIndexofFirstOccurrenceinString;


public class P0028 {
    public int strStr(String haystack, String needle) {
        /*
         * Solution v1: Two Pointers
         *
         * Runtime:  ms @ (beats) %
         * Memory Usage:  MB @ (beats) %
         */

        if (needle.length() > haystack.length()){
            return -1;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            while (haystack.charAt(k) == needle.charAt(j)) {
                if (j == needle.length() - 1){
                    return i;
                }
                j++;
                k++;
                if (k == haystack.length()) {
                    break;
                }
            }
            j = 0;
        }
        return -1;


    }
}
