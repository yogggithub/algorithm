package solutions.p0070_ClimbingStairs;

public class P0070 {
    public static void main(String[] args) {
        P0070 self = new P0070();

        System.out.println(self.climbStairs(2));
        System.out.println(self.climbStairs(3));
        System.out.println(self.climbStairs(4));
    }

    public int climbStairs(int n) {

        // submission 1
        // 列举了4~6的情况，发现符合斐波那契函数，以通项公式求结果
        if (n == 1){
            return 1;
        }else{
            return (int) (1/Math.sqrt(5)
                            * ((Math.pow((1+Math.sqrt(5))/2, n+1))
                            - (Math.pow((1-Math.sqrt(5))/2, n+1))));
        }

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
        // Memory Usage: 32.7 MB, less than 5.26% of Java online submissions for Climbing Stairs.


        // submission 2
        // Brute Force

    }
}
