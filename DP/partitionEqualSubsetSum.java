package DP;

public class partitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,7};
        System.out.println("Recursive solution: " + sumPossible1(arr,arr.length));
        System.out.println("Memoization solution: " + sumPossible2(arr,arr.length));
        // System.out.println("Tabulation solution: " + sumPossible3(arr,arr.length));
    }

    // public static boolean sumPossible3(int[] arr, int n){
    //     int totalSum = 0;
    //     for(int i=0;i<n;i++){
    //         totalSum += arr[i];
    //     }
    //     if(totalSum % 2 != 0) return false;
    //     boolean[][] dp = new boolean[n][totalSum/2+1];
    //     return tabulate(totalSum/2 , arr, n, dp);
    // }

    // private static boolean tabulate(int k, int[] arr, int n, boolean[][] dp) {
    //     for(int i=0;i<n;i++) dp[i][0] = true;
    //     dp[0][arr[0]] = true;

    //     for(int idx=1;idx<n;idx++){
    //         for(int target =1 ; target <=k;target++){
    //             boolean not_take = dp[idx-1][target];
    //             boolean take = false;
    //             if(target >= arr[idx]) take = dp[idx-1][target-arr[idx]];

    //             dp[idx][target] = take || not_take;
    //         }
    //     }
    //     return dp[n-1][k];
    // }

    public static boolean sumPossible1(int[] arr, int n){
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }
        if(totalSum % 2 != 0) return false;

        return partitionPossible(totalSum/2,arr,n-1);
    }

    public static boolean sumPossible2(int[] arr, int n){
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }
        if(totalSum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[n+1][totalSum/2+1];
        return memoize(dp, totalSum/2, arr, n-1);
    }

    private static boolean memoize(Boolean[][] dp, int k, int[] arr, int n) {
        if(k==0) return true;
        if(n == 0) return arr[0] == k;
        if(n<0) return false;
        
        if(dp[n][k] != null) return dp[n][k];

        boolean not_take = memoize(dp, k, arr, n-1);
        boolean take = false;
        if(arr[n] <= k) take = memoize(dp, k-arr[n], arr, n-1);

        return dp[n][k] = take || not_take;
    }

    public static boolean partitionPossible(int k , int[] arr, int n){
        if(k == 0) return true;
        if(n == 0) return k == arr[0];
        boolean not_take = partitionPossible(k, arr, n-1);
        boolean take = false;
        if(k >= arr[n]) take = partitionPossible(k-arr[n], arr, n-1);

        return take || not_take;
    }
}