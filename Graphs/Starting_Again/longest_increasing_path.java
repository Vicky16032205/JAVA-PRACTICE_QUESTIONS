package Graphs.Starting_Again;

import java.util.Arrays;

public class longest_increasing_path {
    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);

        int maxi = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ans = helper(i, j, matrix, 0, dp);
                maxi = Math.max(ans, maxi);
            }
        }
        return maxi;
    }

    public static int helper(int i, int j, int[][] mat, int count, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};
        int ans = 1;
        for(int idx = 0;idx<4;idx++){
            int x = dirX[idx]+i;
            int y = dirY[idx]+j;
            if(possible(x,y,mat)){
                if(mat[x][y] > mat[i][j]){
                    ans = Math.max(ans,1+ helper(x, y, mat, count+1, dp));
                }
            }
        }
        return dp[i][j] = ans;
    }

    public static boolean possible(int x, int y, int[][] mat){
        if(x<0 || x>=mat.length || y<0 || y>=mat[0].length) return false;
        return true;
    }

    public static void main(String[] args) {
        // Test case 1: Basic matrix with increasing paths
        int[][] matrix1 = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        
        int longestPath1 = longestIncreasingPath(matrix1);
        System.out.println("Longest increasing path: " + longestPath1);
        
        System.out.println();
        
        // Test case 2: Matrix with longer increasing paths
        int[][] matrix2 = {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        };
        
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        
        int longestPath2 = longestIncreasingPath(matrix2);
        System.out.println("Longest increasing path: " + longestPath2);
        
        System.out.println();
        
        // Test case 3: Single element matrix
        int[][] matrix3 = {
            {1}
        };
        
        System.out.println("Matrix 3 (single element):");
        printMatrix(matrix3);
        
        int longestPath3 = longestIncreasingPath(matrix3);
        System.out.println("Longest increasing path: " + longestPath3);
        
        System.out.println();
        
        // Test case 4: All elements same (no increasing path possible)
        int[][] matrix4 = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        
        System.out.println("Matrix 4 (all same elements):");
        printMatrix(matrix4);
        
        int longestPath4 = longestIncreasingPath(matrix4);
        System.out.println("Longest increasing path: " + longestPath4);
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
