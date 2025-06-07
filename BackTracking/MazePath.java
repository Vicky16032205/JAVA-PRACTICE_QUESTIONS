package BackTracking;

public class MazePath {
    public static void main(String[] args) {
        int row = 4;
        int col = 6;
        int[][] maze = new int[row][col];
        System.out.print(totalWays(1,1,row,col));
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
