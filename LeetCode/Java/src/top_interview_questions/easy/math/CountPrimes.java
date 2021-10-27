package top_interview_questions.easy.math;

public class CountPrimes {

    /*
     * Solution v1: Brute Force
     *
     * Exceed time limitation
     * This should be good cause tested up to 1000000
     */
    // public int countPrimes(int n) {
    //     // base case, give condition
    //     int[] primes;
    //     if (n < 11) {
    //         primes = new int[11];
    //     } else {
    //         primes = new int[n + 1];
    //     }
    //
    //     primes[0] = 0;
    //     primes[1] = 0;
    //     primes[2] = 0;
    //     primes[3] = 1;
    //     primes[4] = 2;
    //     primes[5] = 2;
    //     primes[6] = 3;
    //     primes[7] = 3;
    //     primes[8] = 4;
    //     primes[9] = 4;
    //     primes[10] = 4;
    //
    //     if (n < 11) {
    //         return primes[n];
    //     }
    //
    //     return countPrimes(n, primes);
    // }
    //
    // public int countPrimes(int n, int[] primes) {
    //     // base case, give condition
    //     if (n < 11) {
    //         // System.out.println("n = " + n + "|" + primes[n]);
    //         return primes[n];
    //     }
    //
    //     if (isPrime(n - 1)) {
    //         primes[n] = 1 + countPrimes(n - 1, primes);
    //         // System.out.println("n = " + n + "|" + primes[n]);
    //     } else {
    //         primes[n] = countPrimes(n - 1, primes);
    //     }
    //     return primes[n];
    // }
    //
    //
    // private boolean isPrime(int n) {
    //     if (n == 1) {
    //         return false;
    //     } else if (n == 2) {
    //         return false;
    //     } else if (n == 3) {
    //         return false;
    //     }
    //
    //     for (int i = 2; i < Math.sqrt(n) + 1; i++) {
    //         if (n % i == 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /*
     * (learn from Internet)
     * Solution v2.1: Sieve of Eratosthenes
     *
     * create a boolean array that contains n-1 element
     * from 2, mark all other element that can dividable by 2
     * then 3, 5... repeat this until reach the end
     * all those element that is in true are primes
     */
    // public int countPrimes(int n) {
    //     int primes = 0;
    //     boolean[] isPrime = new boolean[n];
    //     // mark all number as prime by default
    //     Arrays.fill(isPrime,true);
    //     for (int i = 2; i < n; i++) {
    //         if (!isPrime[i]) {
    //             continue;
    //         }
    //         primes++;
    //         // mark all numbers that dividable by i to false
    //         for (int j = 2; i * j < n; j++) {
    //             isPrime[i * j] = false;
    //         }
    //     }
    //     return primes;
    // }

    /*
     * (learn from Internet)
     * Solution v2.2: Sieve of Eratosthenes
     *
     * Optimized:
     * ignore all even numbers and all even multiples
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        boolean[] primes = new boolean[n];

        //Start at 1 to account for the only even prime 2
        int count = 1;

        //Ignore even numbers
        for (int i = 3; i < n; i += 2) {
            //If prime, then go through and mark all odd multiples as true
            if (!primes[i]) {
                count++;
                //Ignore even multiples
                for (int j = i * 3; j < n; j += i * 2) {
                    primes[j] = true;
                }
            }
        }
        return count;
    }
}
