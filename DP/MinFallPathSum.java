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
        System.out.println("Recursive Answer: "+ recursive(matrix));
        System.out.println("Memoization Answer: " + minFallingPathSum(matrix));
        System.out.println("Tabulation Answer: "+FallingPathSum(matrix));
        System.out.println("Space Optimized Answer: "+FallingSum(matrix));
    }

    public static int recursive(int[][] matrix) {
        int mini = Integer.MAX_VALUE;

        for(int i=0;i<matrix.length;i++){
            int num = Sum(matrix, 0, i);
            mini = Math.min(mini,num);
        }
        return mini;
    }

    public static int Sum(int[][] matrix, int row, int col){
        if(row<0 || row>matrix.length-1 || col<0 || col>matrix.length-1) return Integer.MAX_VALUE;
        if(row == matrix.length-1) return matrix[row][col];

        int downback = Sum(matrix, row+1, col-1);
        int down = Sum(matrix, row+1, col);
        int downfront = Sum(matrix, row+1, col+1);

        return (matrix[row][col] + Math.min(downback, Math.min(down, downfront)));
    }



    public static int FallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        return pathSum2(matrix, matrix.length, matrix[0].length, dp);
    }

    public static int pathSum2(int[][] matrix, int row, int col, int[][] dp){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0) dp[i][j] = matrix[i][j];
                else{
                    int downback = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    int downfront = Integer.MAX_VALUE;

                    if(i-1 > -1 && j+1 < col) downback = dp[i-1][j+1];
                    if(i-1 > -1) down = dp[i-1][j];
                    if(i-1 > -1 && j-1 > -1) downfront = dp[i-1][j-1];

                    dp[i][j] = (matrix[i][j] + Math.min(downback, Math.min(down, downfront)));
                }
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++){
            mini = Math.min(mini, dp[row-1][j]);
        }
        return mini;
    }


    public static int FallingSum(int[][] matrix) {
        return pathSum3(matrix, matrix.length, matrix[0].length);
    }

    public static int pathSum3(int[][] matrix, int row, int col){

        int[] prev = new int[col];
        for(int j=0;j<matrix[0].length;j++){
            prev[j] = matrix[0][j];
        }

        for(int i=1;i<row;i++){
            int[] curr = new int[col];

            for(int j=0;j<col;j++){
                    int downback = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    int downfront = Integer.MAX_VALUE;

                    if(i-1 > -1 && j+1 < col) downback = prev[j+1];
                    if(i-1 > -1) down = prev[j];
                    if(i-1 > -1 && j-1 > -1) downfront = prev[j-1];

                    curr[j] = (matrix[i][j] + Math.min(downback, Math.min(down, downfront)));
            }
            prev = curr;
        }

        int mini = Integer.MAX_VALUE;
        for(int j=0;j<prev.length;j++){
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }
}
