package Graphs.Starting_Again;

import java.util.*;

public class find_max_fruit_collected {
    public static void main(String[] args) {
        // Test case 1: Simple 3x3 grid
        int[][] fruits1 = {
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
        System.out.println("Test 1 - 3x3 grid:");
        System.out.println("Max fruits collected: " + maxCollectedFruits(fruits1));
        System.out.println();

        // Test case 2: 4x4 grid with more fruits
        int[][] fruits2 = {
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1}
        };
        System.out.println("Test 2 - 4x4 grid:");
        System.out.println("Max fruits collected: " + maxCollectedFruits(fruits2));
        System.out.println();

        // Test case 3: 3x3 grid with scattered fruits
        int[][] fruits3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.println("Test 3 - 3x3 grid (all fruits):");
        System.out.println("Max fruits collected: " + maxCollectedFruits(fruits3));
        System.out.println();

        // Test case 4: Minimal 2x2 grid
        int[][] fruits4 = {
            {1, 1},
            {1, 1}
        };
        System.out.println("Test 4 - 2x2 grid:");
        System.out.println("Max fruits collected: " + maxCollectedFruits(fruits4));
    }

    public static int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][][][][][][] dp = new int[n+1][n+1][n+1][n+1][n+1][n+1][n+1];
        for(int[][][][][][] r1 : dp){
            for(int[][][][][] r2 : r1){
                for(int[][][][] r3 : r2){
                    for(int[][][] r4 : r3){
                        for(int[][] r5 : r4){
                            for(int[] r6 : r5){
                                Arrays.fill(r6, -1);
                            }
                        }
                    }
                }
            }
        }
        n = fruits.length-1;
        return fruits[0][0] + fruits[0][n] + fruits[n][0] + maximumFruits(0, 0, 0, n, n, 0, 0, fruits, dp);
    }

    public static int maximumFruits(int i1,int j1,int i2,int j2,int i3,int j3,int m,int[][] fruits,int[][][][][][][] dp){
        int n = fruits.length;
        if(m==n-1 && i1==n-1 && i2 == n-1 && i3==n-1 && j1==n-1 && j2==n-1 && j3==n-1) return 0;
        else if(m>=n-1) return Integer.MIN_VALUE;

        if(dp[i1][j1][i2][j2][i3][j3][m] != -1) return dp[i1][j1][i2][j2][i3][j3][m];

        int[] aX = {1,1,0};    // for child1 moves
        int[] aY = {1,0,1};

        int[] bX = {1,1,1};    // for child2 moves
        int[] bY = {-1,0,1};

        int[] cX = {-1,0,1};    // for child3 moves
        int[] cY = {1,1,1};

        int sum =Integer.MIN_VALUE;

        for(int idx=0;idx<3;idx++){
            int x1 = aX[idx]+i1;
            int y1 = aY[idx]+j1;

            for(int idx2=0;idx2<3;idx2++){
                int x2 = bX[idx2]+i2;
                int y2 = bY[idx2]+j2;

                for(int idx3=0;idx3<3;idx3++){
                    int x3 = cX[idx3]+i3;
                    int y3 = cY[idx3]+j3;

                    int ans = Integer.MIN_VALUE;

                    if(possible(x1,y1,fruits) && possible(x2,y2,fruits) && possible(x3,y3,fruits)){
                        if(!same(x1, y1, x2, y2) && !same(x2, y2, x3, y3) && !same(x1, y1, x3, y3)){
                            ans = fruits[x1][y1] + fruits[x2][y2] + fruits[x3][y3];
                        }
                        else if (same(x1, y1, x2, y2) && same(x2, y2, x3, y3)) {
                            ans = fruits[x1][y1];
                        } 
                        else if (same(x1, y1, x2, y2)) {
                            ans = fruits[x1][y1] + fruits[x3][y3];
                        } 
                        else if (same(x1, y1, x3, y3)) {
                            ans = fruits[x1][y1] + fruits[x2][y2];
                        } 
                        else if (same(x2, y2, x3, y3)) {
                            ans = fruits[x1][y1] + fruits[x2][y2];
                        }

                        int total = ans + maximumFruits(x1,y1,x2,y2,x3,y3,m+1,fruits, dp);
                        sum = Math.max(total, sum);
                    }
                }
            }
        }
        return dp[i1][j1][i2][j2][i3][j3][m] = sum;
    }

    public static boolean possible(int x, int y, int[][] fruits){
        int n = fruits.length;
        if(x<0 || y<0 || x>n-1 || y>n-1) return false;
        return true;
    }

    public static boolean same(int x1, int y1, int x2, int y2){
        return x1==x2 && y1==y2;
    }
}
