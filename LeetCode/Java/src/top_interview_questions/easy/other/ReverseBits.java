package top_interview_questions.easy.other;

public class ReverseBits {
    public int reverseBits(int n) {
        /*
         * (learn from Internet)
         * Solution v1:
         */
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
