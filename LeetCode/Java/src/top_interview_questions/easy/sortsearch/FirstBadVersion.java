package top_interview_questions.easy.sortsearch;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 2126753390;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        /*
         * Solution v1: Dichotomous search
         *
         * Runtime: 24 ms @ (beats) 21.89%
         * Memory Usage: 37.7 MB @ (beats) 19.18%
         */

        int left = 1, right = n;
        while (left < right) {
            // to avoid big enough n that cause overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // add an dummy function to eliminate warning
    private static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}
