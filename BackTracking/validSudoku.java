package BackTracking;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                else{
                    if(!helper(board,i,j,board[i][j])) return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col, char num){
        // check row
        for(int j=0;j<9;j++){
            if(j!=col && board[row][j] == num) return false;
        }
        // check column
        for(int i=0;i<9;i++){
            if(i != row && board[i][col] == num) return false;
        }
        // check matrix
        int startrow = row/3*3;
        int startcol = col/3*3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(i!=row && j!=col && board[i][j] == num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        validSudoku solver = new validSudoku();
        boolean result = solver.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + result);
    }
}
