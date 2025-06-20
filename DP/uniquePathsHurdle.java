package DP;
import java.util.*;

public class uniquePathsHurdle {
    public static void main(String[] args) {
        int[][] maze ={ {0,1},
                        {0,0}
                    };
        int[][] dp = new int[maze.length+1][maze[0].length+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(totalWays(maze, 0, 0, maze.length-1, maze[0].length-1, dp));
    }
    private static int totalWays(int[][] maze, int sr, int sc, int er, int ec, int[][] dp){
        if(sr<0 || sc<0 || sr>er || sc>ec) return 0;
        if(maze[sr][sc] == 1) return 0;

        if(sr == er && sc == ec) return 1;

        if(dp[sr][sc] != -1) return dp[sr][sc];

        int downways = totalWays(maze, sr+1 , sc , er, ec,dp);
        int rightways = totalWays(maze, sr , sc+1 , er, ec,dp);

        return dp[sr][sc] = downways + rightways;
    }   
}
