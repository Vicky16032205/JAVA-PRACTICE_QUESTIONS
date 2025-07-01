package DP;
import java.util.* ;

public class minimumCoinsRequ {

    public static int minimumCoinsTabu(int p, int[] arr){
        int[][] dp = new int[arr.length][p+1];

        return minCoinsTabulation(p,arr,arr.length, dp);
    }

    public static int minCoinsTabulation(int p, int[] arr, int n, int[][] dp){
        for(int i=0;i<=p;i++){
            if(i%arr[0] == 0) dp[0][i] = i/arr[0];
            else dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<n;i++){
            for(int T=0;T<=p;T++){
                int not_pick = 0 + dp[i-1][T];
                int pick = (Integer.MAX_VALUE);
                if(arr[i] <= T) pick = 1 + dp[i][T-arr[i]];

                dp[i][T] = Math.min(pick , not_pick);
            }
        }
        return dp[n-1][p];
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
        System.out.println(minimumCoinsTabu(changes,arr));
    }
}



