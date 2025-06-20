package DP;

public class minPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] dp = new int[grid.length][grid[0].length];

        System.out.println(tabulation(grid,dp));
    }

    public static int tabulation(int[][]grid, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[0][0] = grid[0][0];
                else{
                    int up =Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
