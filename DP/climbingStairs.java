package DP;

public class climbingStairs {
    public static void main(String[] args) {
         int n = 2;
        System.out.println("total ways possible: " + countWays(n));
    }

    public static int countWays(int n){
        // if(n==0) return 1;
        // if(n<1) return 0;

        // int oneJump = countWays(n-1);
        // int twoJump = countWays(n-2);

        // return oneJump+twoJump;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}