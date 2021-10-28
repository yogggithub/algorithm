package top_interview_questions.easy.other;

public class NumberOfOneBit {
    // treat n as an unsigned value
    public int hammingWeight(int n) {

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 5 ms @ (beats) 0%
         * Memory Usage: 35.9 MB @ (beats) 67.06%
         */
        // long bigN;
        // int count = 0;
        // // convert to decimal number
        // if (n < 0) {
        //     // convert negative to postive
        //     bigN = (long) Integer.MIN_VALUE + n;
        //     // for negative, the first bit is 1
        //     count++;
        // } else {
        //     bigN = n;
        // }
        //
        // System.out.println(bigN);
        // while (bigN >= 2) {
        //     count += bigN % 2;
        //     bigN /= 2;
        // }
        //
        // if (bigN == 1) {
        //     count++;
        // }
        // return count;

        /*
         * (learn from Internet)
         * Solution v2: bit calculate
         */
        int bits = 0;
        int mask = 1;
        // given condition: 32 bits binary number
        for (int i = 0; i < 32; i++) {
            // from leftmost
            // if is 1, than bit compare should be 0
            if ((n & mask) != 0) {
                bits++;
            }
            // move bit to right one bit
            mask <<= 1;
        }
        return bits;
    }
}
