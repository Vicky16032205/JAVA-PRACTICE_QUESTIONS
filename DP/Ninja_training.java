package DP;

public class Ninja_training {
    public static void main(String[] args) {
        int[][] arr = {
                        {1, 2, 5}, 
                        {3, 1, 1}, 
                        {3, 3, 3}
                    };
        int[][] dp = new int[arr.length][4];
        System.out.println(maximumPoints(arr,arr.length-1,3,dp));
    }

    private static int maximumPoints(int[][] arr, int n, int done, int[][] dp) {
        int maxi = 0;
        if(n<0) return 0;
        if(dp[n][done] != 0) return dp[n][done];
        if(n == 0){
            for(int i=0;i<3;i++){
                if(i == done) continue;
                maxi = Math.max(maxi, arr[0][i]);
            }
            return maxi;
        }
        
        for(int i=0;i<3;i++){
            if(i == done) continue;
            int points = arr[n][i] + maximumPoints(arr, n-1, i, dp);
            maxi = Math.max(maxi, points);
        }
        return dp[n][done] = maxi;
    }

}
