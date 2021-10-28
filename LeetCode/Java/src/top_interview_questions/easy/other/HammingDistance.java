package top_interview_questions.easy.other;

public class HammingDistance {
    public int hammingDistance(int x, int y) {

        /*
         * Solution v1: bit calculate ^
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.1 MB @ (beats) 49.17%
         */
        // // ^ calculate, give 1 if same, give 0 if no same
        // int count = x ^ y;
        //
        // int result = 0;
        // while (count >= 2) {
        //     result += count % 2;
        //     count /= 2;
        // }
        // if(count == 1){
        //     result++;
        // }
        // return result;

        /*
         * (learn from Internet)
         * Solution v2: Optimize
         */
        return Integer.bitCount(x ^ y);
    }
}
