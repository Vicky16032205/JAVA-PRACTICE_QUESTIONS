package Graphs.PART1_Assignments;
import java.util.*;

public class rotten_oranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count1 = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1) count1++;
            }
        }
        if(count1 == 0) return 0;

        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c = rotten[1];
                
                int[][] dir = {{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
                for(int[] directions : dir){
                    int nr = directions[0];
                    int nc = directions[1];

                    if(nr<0 || nr>=m || nc<0 || nc>=n || grid[nr][nc] == 2 || grid[nr][nc] == 0) continue;
                    queue.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                    count1--;

                    if(count1 == 0){
                        return time+1;
                    }
                }
            }
            time++;
        }

        return (count1==0) ? time : -1;
    }
}


















// PROBLEM STATEMENT :
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.