package BackTracking;

public class maxKnights {
    static int max = 8;
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }
        nKnights(board, 0, 0, 0);
    }
    public static boolean isValid(char[][] board, int row, int col){
        int n = board.length;
        int i,j;

        // 2up-1right
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && board[i][j] == 'K') return false;
        // 2up-1left
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && board[i][j] == 'K') return false;
        // 2down-1right
        i=row+2;
        j=col+1;
        if(i<n && j<n && board[i][j] == 'K') return false;
        // 2down-1left
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && board[i][j] == 'K') return false;


        // 2left-1up
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && board[i][j] == 'K') return false;
        // 2left-1down
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && board[i][j] == 'K') return false;
        // 2right-1up
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && board[i][j] == 'K') return false;
        // 2right-1down
        i=row+1;
        j=col+2;
        if(i<n && j<n && board[i][j] == 'K') return false;

        return true;
    }
    public static void nKnights(char[][] board, int row, int col,int num){
        int n = board.length;
        if(row == n){
            if(num == max){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }


        else if(isValid(board, row, col)){
            board[row][col] = 'K';
            if(col<n-1) nKnights(board, row, col+1, num+1);
            else nKnights(board, row+1, 0, num+1);
            board[row][col] = 'X';
        }
        if(col<n-1) nKnights(board, row, col+1, num);
        else nKnights(board, row+1, 0, num);
    }
}
