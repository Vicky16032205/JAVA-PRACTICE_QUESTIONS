package DP;

import java.util.Arrays;

public class MinFallPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int mini = Integer.MAX_VALUE;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int i=0;i<matrix.length;i++){
            int num = pathSum(matrix, 0, i, dp);
            mini = Math.min(mini,num);
        }
        return mini;
    }

    public static int pathSum(int[][] matrix, int row, int col, int[][] dp){
        if(row<0 || row>matrix.length-1 || col<0 || col>matrix.length-1) return Integer.MAX_VALUE;
        if(row == matrix.length-1) return matrix[row][col];

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int downback = pathSum(matrix, row+1, col-1, dp);
        int down = pathSum(matrix, row+1, col, dp);
        int downfront = pathSum(matrix, row+1, col+1, dp);

        dp[row][col] = (matrix[row][col] + Math.min(downback, Math.min(down, downfront)));
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix ={
                        {2,1,3}, 
                        {6,5,4}, 
                        {7,8,9}
                    };

        System.out.println(minFallingPathSum(matrix));
    }
}
