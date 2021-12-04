package solutions.p0461_HammingDistance;

import java.util.BitSet;

public class P0461 {
    public int hammingDistance(int x, int y) {
        /*
         * Solution v1.1: Bit calculation
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 35.8 MB @ (beats) 60.28%
         */
        // // difference in integer number
        // int dif = x ^ y;
        //
        // int result = 0;
        //
        // // convert number to bits
        // while (dif >= 2) {
        //     result += dif % 2;
        //     dif /= 2;
        // }
        // // final reminder
        // if (dif == 1) {
        //     result++;
        // }
        // return result;

        /*
         * (learn from Internet)
         * Solution v1.2: More professional
         */
        // int xor = x ^ y, count = 0;
        //
        // while (xor != 0) {
        //     xor &= (xor - 1);
        //     count++;
        // }
        // return count;


        /*
         * (learn from Internet)
         * Solution v1.3: Optimized
         */
        // return Integer.bitCount(x ^ y);

        /*
         * (learn from Internet)
         * Solution v2: Byte array OR String
         */
        byte[] xb = new BitSet(x).toByteArray();
        byte[] yb = new BitSet(y).toByteArray();
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (xb[i] != yb[i]) {
                result++;
            }
        }
        return result;
    }
}
