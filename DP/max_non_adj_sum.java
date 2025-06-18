package DP;

public class max_non_adj_sum {
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println("Recursion answer: " + findMaxSum(arr,arr.length-1));

        int[] dp = new int[arr.length+1];
        System.out.println("Memoization answer: " + MemoFindMaxSum(arr,arr.length-1,dp));

        // int[] dp2 = new int[arr.length];
        // System.out.println("Memoization answer: " + TabuFindMaxSum(arr,arr.length-1,dp2));
    }

    public static int findMaxSum(int[] arr, int n){
        if(n == 0) return arr[0];
        if(n < 0) return 0;

        int pick = arr[n] + findMaxSum(arr, n-2);
        int non_pick = 0 + findMaxSum(arr, n-1);

        return Math.max(pick, non_pick);
    }

    public static int MemoFindMaxSum(int[] arr, int n, int[] dp){
        if(n==0) return arr[0];
        if(n<1) return 0;
        if(dp[n] != 0) return dp[n];

        int pick = arr[n] + MemoFindMaxSum(arr, n-2, dp);
        int non_pick = 0 + MemoFindMaxSum(arr, n-1, dp);

        return dp[n] = Math.max(pick, non_pick);
    }

    // public static int TabuFindMaxSum(int[] arr, int n, int[] dp){
        
    //     return 0;
    // }
}