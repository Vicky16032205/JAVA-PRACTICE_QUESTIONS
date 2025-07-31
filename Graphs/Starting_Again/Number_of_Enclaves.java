package Graphs.Starting_Again;

class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 1){
                dfs(i,0,board,vis);
            }
            if(!vis[i][m-1] && board[i][m-1] == 1){
                dfs(i,m-1,board,vis);
            }
        }

        for(int i=0;i<m;i++){
            if(!vis[0][i] && board[0][i] == 1){
                dfs(0,i,board,vis);
            }
            if(!vis[n-1][i] && board[n-1][i] == 1){
                dfs(n-1,i,board,vis);
            }
        }

        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int[][] board, boolean[][] vis){
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

    public boolean possible(int i, int j, int[][] board, boolean[][] vis){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == 0 || vis[i][j]){
            return false;
        }
        return true;
    }
}

public class Number_of_Enclaves {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Basic enclaves example
        int[][] board1 = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        
        System.out.println("Board 1:");
        printBoard(board1);
        
        int enclaves1 = solution.numEnclaves(board1);
        System.out.println("Number of enclaves: " + enclaves1);
        
        System.out.println();
        
        // Test case 2: Land connected to border (no enclaves)
        int[][] board2 = {
            {0,1,1,0},
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0}
        };
        
        System.out.println("Board 2:");
        printBoard(board2);
        
        int enclaves2 = solution.numEnclaves(board2);
        System.out.println("Number of enclaves: " + enclaves2);
        
        System.out.println();
        
        // Test case 3: Multiple separate enclaves
        int[][] board3 = {
            {0,0,0,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,1,0,0},
            {0,0,0,0,0}
        };
        
        System.out.println("Board 3:");
        printBoard(board3);
        
        int enclaves3 = solution.numEnclaves(board3);
        System.out.println("Number of enclaves: " + enclaves3);
        
        System.out.println();
        
        // Test case 4: All water (no enclaves)
        int[][] board4 = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        
        System.out.println("Board 4 (all water):");
        printBoard(board4);
        
        int enclaves4 = solution.numEnclaves(board4);
        System.out.println("Number of enclaves: " + enclaves4);
        
        System.out.println();
        
        // Test case 5: Large enclave surrounded by water
        int[][] board5 = {
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,1,1,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
        };
        
        System.out.println("Board 5 (large enclave):");
        printBoard(board5);
        
        int enclaves5 = solution.numEnclaves(board5);
        System.out.println("Number of enclaves: " + enclaves5);
    }

    public static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
