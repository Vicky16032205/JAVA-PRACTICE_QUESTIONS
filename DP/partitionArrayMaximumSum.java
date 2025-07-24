package DP;

import java.util.Arrays;

public class partitionArrayMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k=3;

        int[] dp = new int[arr.length+1];
        Arrays.fill(dp , -1);
        System.out.println( maximum(0, k , arr, dp));

        int[] dp2 = new int[arr.length+1];
        System.out.println(tabulation(k, arr, dp2));
    }

    public static int tabulation(int k, int[] arr, int[] dp){
        for(int idx=arr.length-1;idx>=0;idx--){
            int len = 0, ans =0;
            int max = Integer.MIN_VALUE;
            int res = 0;
            for(int i = idx;i<Math.min(idx+k, arr.length); i++){
                len++;
                max = Math.max(arr[i], max);
                ans = len * max + dp[i+1];
                res = Math.max(ans , res);
            }
            dp[idx] = res;
        }
        return dp[0];
    }

    public static int maximum(int idx, int k, int[] arr, int[] dp){
        if(idx == arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int len = 0, ans =0;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i = idx;i<Math.min(idx+k, arr.length); i++){
            len++;
            max = Math.max(arr[i], max);
            ans = len * max + maximum(i+1, k, arr, dp);
            res = Math.max(ans , res);
        }
        return dp[idx] = res;
    }
}
