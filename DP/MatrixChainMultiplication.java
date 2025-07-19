package DP;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println(matrixMultiplication(arr));
    }

    static int matrixMultiplication(int arr[]) {
        // int[][] dp = new int[arr.length][arr.length];
        int[][] dp2 = new int[arr.length][arr.length];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return func(1, arr.length-1, arr, dp);
        return f(arr, dp2);
    }
    
    static int func(int i, int j, int[] arr, int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE-1000;
        for(int k=i;k<j;k++){
            int ans = (arr[i-1] *arr[k] *arr[j]) + func(i,k,arr,dp) + func(k+1, j, arr,dp);
            mini = Math.min(mini, ans);
        }
        return dp[i][j] = mini;
    }
    
    static int f( int[] arr, int[][] dp){
        
        for(int i=arr.length-2;i>=1;i--){
            for(int j=i+1;j<arr.length;j++){
                int mini = Integer.MAX_VALUE-1000;
                for(int k=i;k<j;k++){
                    int ans = (arr[i-1] *arr[k] *arr[j]) + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini, ans);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][arr.length-1];
    }
}
