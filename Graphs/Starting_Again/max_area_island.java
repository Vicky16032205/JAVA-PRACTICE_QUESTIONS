package Graphs.Starting_Again;

public class max_area_island {
    public static int maxAreaOfIsland(int[][] grid) {
        int maxi = 0;

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int ans = gridLength(grid, i, j,vis,1);
                    maxi = Math.max(ans , maxi);
                }
            }
        }
        return maxi;
    }

    public static int gridLength(int[][] grid, int i, int j, boolean[][] vis, int count){
        vis[i][j] = true;

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        for(int idx=0;idx<4;idx++){
            int x = dirX[idx] + i;
            int y = dirY[idx] + j;

            if(possible(x,y,vis,grid)){
                count++;
                count = gridLength(grid,x,y,vis,count);
            }
        }
        return count;
    }

    public static boolean possible(int i, int j, boolean[][] vis, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]  || grid[i][j]==0) return false;
        return true;
    }
    
    public static void main(String[] args) {
        // Test case 1: Multiple islands with different sizes
        int[][] grid1 = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };
        
        System.out.println("Grid 1:");
        printGrid(grid1);
        
        int maxArea1 = maxAreaOfIsland(grid1);
        System.out.println("Max area of island: " + maxArea1);
        
        System.out.println();
        
        // Test case 2: Single large island
        int[][] grid2 = {
            {1,1,1,1,0},
            {0,1,1,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0}
        };
        
        System.out.println("Grid 2:");
        printGrid(grid2);
        
        int maxArea2 = maxAreaOfIsland(grid2);
        System.out.println("Max area of island: " + maxArea2);
        
        System.out.println();
        
        // Test case 3: No islands (all water)
        int[][] grid3 = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };
        
        System.out.println("Grid 3 (all water):");
        printGrid(grid3);
        
        int maxArea3 = maxAreaOfIsland(grid3);
        System.out.println("Max area of island: " + maxArea3);
        
        System.out.println();
        
        // Test case 4: Single cell island
        int[][] grid4 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        
        System.out.println("Grid 4 (single cell island):");
        printGrid(grid4);
        
        int maxArea4 = maxAreaOfIsland(grid4);
        System.out.println("Max area of island: " + maxArea4);
    }

    public static void printGrid(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
