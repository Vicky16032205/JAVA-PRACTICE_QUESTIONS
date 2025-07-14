package DP;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,11,2,10,4,5,2,1};
        System.out.println(lbs(arr));
    }

    private static int lbs(int[] arr){
        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        return bitonic(arr, dp1, dp2);
    }

    private static int bitonic(int[] arr, int[] dp1, int[] dp2){
        int n = arr.length-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
                if(arr[n-i] > arr[n-j]){
                    dp2[n-i] = Math.max(dp2[n-i], 1+dp2[n-j]);
                }
            }
        }

        int ans = -1;
        int[] longest = new int[arr.length];
        for(int i=0;i<=n;i++){
            longest[i] = Math.abs(dp1[i] + dp2[i]) -1 ;
            ans = Math.max(ans, longest[i]);
        }

        return ans;
    }
}
