package DP;
import java.util.*;

public class K_frog_jumps {
    static int k = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {30, 20, 50, 10, 40};
        System.out.println("Using Recursion : " + minCostRecursive(arr,arr.length-1));

        // int[] dp = new int[arr.length+1];
        // Arrays.fill(dp,-1);
        // System.out.println("Using Memoization : " + minCostDP(arr,arr.length-1,dp));

        // int[] dp2 = new int[arr.length];
        // System.out.println("Using Tabulation : " + minCostTabulation(arr , arr.length-1, dp2));
        sc.close();
    }

    public static int minCostRecursive(int[] height, int n){
        if(n==0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                int mini = minCostRecursive(height, n-i) + Math.abs(height[n] - height[n-i]);
                min = Math.min(min , mini);
            }
        }
        return min;
    }

    // public static int minCostDP(int[] height, int n, int[] dp){
    //     if(n==0) return 0;
    //     if(dp[n] != -1) return dp[n];

    //     int min = Integer.MAX_VALUE;
    //     for(int j=1;j<=k;j++){
    //         if(n-j>=0){
    //             int mini = minCostDP(height, n-j, dp) + Math.abs(height[n] - height[n-j]);
    //             min = Math.min(min, mini);
    //         }
    //     }
    //     return dp[n] = min;
    // }

    // public static int minCostTabulation(int[] height, int n, int[] dp){
    //     dp[0] = 0;

    //     for(int i=1;i<=n;i++){
    //         int cost = Integer.MAX_VALUE;
    //         for(int j=1;j<=k;j++){
    //             if(i-j>=0){
    //                 int jump = dp[i-j] + Math.abs(height[i] - height[i-j]);
    //                 cost = Math.min(cost, jump);
    //             }
    //         }
    //         dp[i] = cost;
    //     }
    //     return dp[n];
    // }
}