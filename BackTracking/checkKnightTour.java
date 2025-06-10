package BackTracking;

class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return helper(grid,0,0,0);
    }

    public boolean helper(int[][] grid, int row, int col, int num){
        int n = grid.length;
        if(grid[row][col] == n*n-1) return true;
        int i,j;

        // 2up-1right
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2up-1left
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2down-1right
        i=row+2;
        j=col+1;
        if(i<n && j<n && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2down-1left
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);


        // 2left-1up
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2left-1down
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2right-1up
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2right-1down
        i=row+1;
        j=col+2;
        if(i<n && j<n && grid[i][j] == num+1) return helper(grid,i,j,num+1);

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
            {0, 59, 38, 33, 30, 17, 8, 63},
            {37, 34, 31, 60, 9, 62, 29, 16},
            {58, 1, 36, 39, 32, 27, 18, 7},
            {35, 48, 41, 26, 61, 10, 15, 28},
            {42, 57, 2, 49, 40, 23, 6, 19},
            {47, 50, 45, 54, 25, 20, 11, 14},
            {56, 43, 52, 3, 22, 13, 24, 5},
            {51, 46, 55, 44, 53, 4, 21, 12}
        };
        boolean result = sol.checkValidGrid(grid);
        System.out.println("Is valid knight's tour? " + result);
    }
}