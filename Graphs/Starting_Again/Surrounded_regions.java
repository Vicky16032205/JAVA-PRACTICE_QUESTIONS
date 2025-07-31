package Graphs.Starting_Again;

public class Surrounded_regions {
    public static void main(String[] args) {
        char[][] board1 = {
        {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}
    };
    
    System.out.println("Original board:");
    printBoard(board1);
    
    solve(board1);
    
    System.out.println("After solving:");
    printBoard(board1);
    
    System.out.println();
    }

    public static void printBoard(char[][] board) {
    for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
}

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,board,vis);
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,board,vis);
            }
        }

        for(int i=0;i<m;i++){
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs(0,i,board,vis);
            }
            if(!vis[n-1][i] && board[n-1][i] == 'O'){
                dfs(n-1,i,board,vis);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j] != 'X'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int i, int j, char[][] board, boolean[][] vis){
        vis[i][j] = true;

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        for(int idx = 0;idx<4;idx++){
            int x = dirX[idx] + i;
            int y = dirY[idx] + j;

            if(possible(x,y,board,vis)){
                dfs(x,y,board,vis);
            }
        }
    }

    public static boolean possible(int i, int j, char[][] board, boolean[][] vis){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == 'X' || vis[i][j]){
            return false;
        }
        return true;
    }
}
