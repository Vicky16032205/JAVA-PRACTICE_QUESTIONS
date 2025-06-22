package DP;

import java.util.Arrays;

public class cherryPickup {
    public static void main(String[] args) {
        int[][] grid = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };
        System.out.println("Recursive Answer: " +cherryPickup2(grid));
        System.out.println("Memoization Answer: " +cherryPickup3(grid));
        System.out.println("Tabulation Answer: " +cherryPickup4(grid));
    }

    public static int cherryPickup4(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];

        return f3(r,c,grid, dp);
    }

    public static int f3(int n, int m, int[][] grid, int[][][] dp){
        for(int j1 = 0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j1 = 0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){

                    int maxi = 0;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){

                            int val = 0;
                            if(j1 == j2) val = grid[i][j1];
                            else val = grid[i][j1] + grid[i][j2];

                            if(j1+dj1 >=0 && j2+dj2 >=0 && j1+dj1 <m && j2+dj2 <m){
                                val += dp[i+1][j1+dj1][j2+dj2];
                            }
                            maxi = Math.max(maxi, val);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }

    public static int cherryPickup3(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for(int[][] row : dp){
            for (int[] col : row){
                Arrays.fill(col, -1);
            }
        }
        return f2(0,0,c-1,r,c,grid, dp);
    }

    public static int f2(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp){
        if(j1<0 || j2<0 || j1>=c || j2>=c) return 0;

        if(i == r-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2] ;
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi = 0;

        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int val = f2(i+1, j1+dj1, j2+dj2, r, c, grid, dp);
                if(j1 == j2) val += grid[i][j1];
                else val += grid[i][j1] + grid[i][j2];

                maxi = Math.max(val, maxi);
                dp[i][j1][j2] = maxi;
            }
        }
        return maxi;
    }

    public static int cherryPickup2(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        return f(0,0,c-1,r,c,grid);
    }

    public static int f(int i, int j1, int j2, int r, int c, int[][] grid){
        if(j1<0 || j2<0 || j1>=c || j2>=c) return 0;

        if(i == r-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2] ;
        }

        int maxi = 0;

        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int val = f(i+1, j1+dj1, j2+dj2, r, c, grid);
                if(j1 == j2) val += grid[i][j1];
                else val += grid[i][j1] + grid[i][j2];

                maxi = Math.max(val, maxi);
            }
        }
        return maxi;
    }
}