package DP;

public class minAbsDiff_partSum {
    static int totSum =0;
    public static void main(String[] args) {
        int[] arr = {8,6,5};
        totSum =0;
        for(int i=0;i<arr.length;i++){
            totSum += arr[i];
        }

        boolean[][] dp = new boolean[arr.length][totSum+1];
        System.out.println(tabulate(arr,arr.length,totSum, dp));
        System.out.println(minDiffPoss(arr,arr.length,dp,0,totSum));
    } 

    private static boolean tabulate(int[] arr, int n, int k, boolean[][] dp) {
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int idx = 1;idx<n;idx++){
            for(int target=1;target<=k;target++){
                boolean not_take = dp[idx-1][target];
                boolean take = false;
                if(arr[idx] <= target) take = dp[idx-1][target-arr[idx]];

                dp[idx][target] = take || not_take;
            }
        }
        return dp[n-1][k];
    }

    private static int minDiffPoss(int[] arr, int n, boolean[][] dp, int st, int end) {
        boolean[] possSum = new boolean[end+1];

        for(int i=0;i<=end;i++){
            if(dp[n-1][i]) possSum[i] = true;
        }

        int mini = Integer.MAX_VALUE;

        for(int i=0;i<=end/2;i++){
            if(possSum[i]){
                int sum1 = i;
                int sum2 = totSum - sum1;
                mini = Math.min(mini , Math.abs(sum1-sum2));
            }
        }
        return mini;
    }
}