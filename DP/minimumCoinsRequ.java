package DP;
import java.util.* ;

public class minimumCoinsRequ {

    public static int minimumCoinsTabu(int p, int[] arr){
        int[][] dp = new int[arr.length-1][p+1];

        return minCoinsTabulation(p,arr,arr.length-1, dp);
    }

    public static int minCoinsTabulation(int p, int[] arr, int n, int[][] dp){

        return 0;
    }


    public static int minimumCoins(int p, int[] arr){
        int[][] dp = new int[arr.length][p+1];
        for(int[] row : dp) Arrays.fill(row , -1);

        return minCoins(p,arr,arr.length-1, dp);
    }

    public static int minCoins(int p, int[] arr, int n, int[][] dp){
        if(n==0){
            if(p % arr[0] == 0) return p/arr[0];
            else return Integer.MAX_VALUE;
        }
        if(dp[n][p] != -1) return dp[n][p];
        int not_pick = 0 + minCoins(p,arr,n-1,dp);
        int pick = (Integer.MAX_VALUE-100);
        if(arr[n] <= p) pick = 1 + minCoins((p-arr[n]) , arr, n, dp);

        return dp[n][p] = Math.min(not_pick , pick);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        int changes = 8;
        System.out.println(minimumCoins(changes,arr));
        // System.out.println(minimumCoinsTabu(changes,arr));
    }
}



