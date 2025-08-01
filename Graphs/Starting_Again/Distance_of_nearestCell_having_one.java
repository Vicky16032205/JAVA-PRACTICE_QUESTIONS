package Graphs.Starting_Again;
import java.util.*;

public class Distance_of_nearestCell_having_one {

    public static class Pair{
        int i;
        int j;
        
        public Pair(int x, int y){
            this.i = x;
            this.j = y;
        }
    }

    public static int[][] nearest(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque();
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] counting = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    queue.add(new Pair(i,j));
                    vis[i][j] = true;
                }
            }
        }

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};
        
        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            
            for(int idx=0;idx<4;idx++){
                int x= dirX[idx] + curr.i;
                int y= dirY[idx] + curr.j;
                
                if(possible(x,y,grid,vis)){
                    counting[x][y] = counting[curr.i][curr.j]+1;
                    vis[x][y] = true;
                    queue.add(new Pair(x,y));
                }
            }
        }
        
        return counting;
    }
    
    
    public static boolean possible(int i, int j, int[][] grid, boolean[][] vis){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j] || grid[i][j] != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1: Basic grid with ones and zeros
        int[][] grid1 = {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,1,1}
        };
        
        System.out.println("Original Grid 1:");
        printGrid(grid1);
        
        int[][] result1 = nearest(grid1);
        System.out.println("Distance to nearest 1:");
        printGrid(result1);
        
        System.out.println();
        
        // Test case 2: Single 1 in center
        int[][] grid2 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        
        System.out.println("Original Grid 2:");
        printGrid(grid2);
        
        int[][] result2 = nearest(grid2);
        System.out.println("Distance to nearest 1:");
        printGrid(result2);
        
        System.out.println();
        
        // Test case 3: All ones (distance should be 0 everywhere)
        int[][] grid3 = {
            {1,1},
            {1,1}
        };
        
        System.out.println("Original Grid 3 (all ones):");
        printGrid(grid3);
        
        int[][] result3 = nearest(grid3);
        System.out.println("Distance to nearest 1:");
        printGrid(result3);
        
        System.out.println();
        
        // Test case 4: Larger grid with mixed pattern
        int[][] grid4 = {
            {0,0,0,0,0},
            {0,1,0,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {0,0,0,0,0}
        };
        
        System.out.println("Original Grid 4:");
        printGrid(grid4);
        
        int[][] result4 = nearest(grid4);
        System.out.println("Distance to nearest 1:");
        printGrid(result4);
    }

    public static void printGrid(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
