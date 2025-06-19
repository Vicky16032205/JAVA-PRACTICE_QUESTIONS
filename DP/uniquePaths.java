package DP;

public class uniquePaths {
    public static void main(String[] args) {
        int row = 4;
        int col = 6;
        System.out.println("Recursive method answer: " +totalWays(1,1,row,col));

        int[][] dp = new int[row+1][col+1];
        System.out.println("Memoization method answer: " +countWays(1,1,row,col,dp));

        int[][] dp2 = new int[row][col];
        System.out.println("Tabulation method answer: " +TabulationWays(row,col,dp2));

        System.out.println("Space optimized answer: " +spaceOptimized(row,col));
    }

    private static int spaceOptimized(int er, int ec){
        int[] prev = new int[ec];

        for(int i=0;i<er;i++){
            int[] curr = new int[ec];
            for(int j=0;j<ec;j++){
                if(i==0 && j==0) curr[j] = 1;
                else{
                    int right = 0;
                    int down = 0;
                    if(j>0) right = curr[j-1];
                    if(i>0) down = prev[j];
                    curr[j] = right+down;
                }
            }
            prev = curr;
        }
        return prev[ec-1];
    }

    private static int TabulationWays(int er, int ec, int[][] dp) {
        for(int i=0;i<er;i++){
            for(int j=0;j<ec;j++){
                if(i==0 && j==0) dp[0][0] = 1;
                else{
                    int right = 0;
                    int down = 0;
                    if(j>0) right = dp[i][j-1] ;
                    if(i>0) down = dp[i-1][j] ;

                    dp[i][j] = right+down;
                }
            }
        }
        return dp[er-1][ec-1];
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
