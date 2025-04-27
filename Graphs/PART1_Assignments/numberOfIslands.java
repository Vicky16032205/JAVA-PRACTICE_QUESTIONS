package Graphs.PART1_Assignments;

public class numberOfIslands {
    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // for every 1 the user finds, make a recursive call for it and increase the number of times the recursive call been made.
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid , i , j);
                    count++;
                }
            }
        }
        return count;
    }

    // in this check if the node is not out of bound or marked already visited, if any condition is true return that call.
    public void dfs(char[][] grid , int i , int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '2' || grid[i][j] == '0') return;

        // mark the node 1 to 2, so that machine can understand that the node had been visited.
        grid[i][j] = '2';
       
        // after that make recursive calls in its all 4 directions to find interconnected nodes(islands).
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}












// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

            // Example 1:

                    // Input: grid = [
                    //   ["1","1","1","1","0"],
                    //   ["1","1","0","1","0"],
                    //   ["1","1","0","0","0"],
                    //   ["0","0","0","0","0"]
                    // ]
                    // Output: 1
            // Example 2:

                    // Input: grid = [
                    //   ["1","1","0","0","0"],
                    //   ["1","1","0","0","0"],
                    //   ["0","0","1","0","0"],
                    //   ["0","0","0","1","1"]
                    // ]
                    // Output: 3

// So the questions is asking that we need to count how many islands are connected to each other and two islands will be present
// only if there is water alongside there all 4 directions in which they can move i.e., UP, DOWN, RIGHT, and LEFT.

// In order to approach this solution, we need to mark all islands so that we can know whether it had been visited or not.
// After that, traverse the adjacent nodes to find connected islands















// This is like unconnected graphs, in which there are multiple graphs present and needed to find them all.