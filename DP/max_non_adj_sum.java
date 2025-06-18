package DP;

public class max_non_adj_sum {
    public static void main(String[] args) {
        int[] arr = {316, 30875, 28056, 29256, 6771, 7084, 5506, 12147, 2937};
        System.out.println("Recursion answer: " + findMaxSum(arr,arr.length-1));

        int[] dp = new int[arr.length+1];
        System.out.println("Memoization answer: " + MemoFindMaxSum(arr,arr.length-1,dp));

        int[] dp2 = new int[arr.length];
        System.out.println("Memoization answer: " + TabuFindMaxSum(arr,arr.length-1,dp2));

        System.out.println("Space optimized answer: " + spaceOptimize(arr, arr.length-1));
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

    public static int TabuFindMaxSum(int[] arr, int n, int[] dp){
        dp[0] = arr[0];

        for(int i=1;i<=n;i++){
            int pick = arr[i];
            if(i>1) pick += dp[i-2];
            int not_pick = 0 + dp[i-1];
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[n];
    }

    public static int spaceOptimize(int[] arr, int n){
        int prev = arr[0];
        int prev2 = 0;

        for(int i=1;i<=n;i++){
            int pick = arr[i];
            if(i>1) pick += prev2;

            int not_pick = 0 + prev;

            int curr = Math.max(pick, not_pick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}