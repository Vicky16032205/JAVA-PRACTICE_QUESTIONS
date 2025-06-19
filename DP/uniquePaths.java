package DP;

public class uniquePaths {
    public static void main(String[] args) {
        int row = 4;
        int col = 6;
        System.out.println("Recursive method answer: " +totalWays(1,1,row,col));

        int[][] dp = new int[row+1][col+1];
        System.out.println("Memoization method answer: " +countWays(1,1,row,col,dp));
    }

    private static int countWays(int sr, int sc, int er, int ec, int[][] dp) {
        if(sr < 1 || sc < 1 || sr>er || sc>ec) return 0;

        if(sr == er && sc == ec) return 1;

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int downways = totalWays(sr+1 , sc , er, ec);
        int rightways = totalWays(sr , sc+1 , er, ec);

        return dp[sr][sc] = downways + rightways;
    }

    private static int totalWays(int sr, int sc, int er, int ec) {
        if(sr == er && sc == ec){
            return 1;
        }
        if(sr < 0 || sc < 0 || sr > er || sc > ec){
            return 0;
        }

        int downways = totalWays(sr+1 , sc , er, ec);
        int rightways = totalWays(sr , sc+1 , er, ec);

        int count = downways + rightways;
        return count;
    }
}
