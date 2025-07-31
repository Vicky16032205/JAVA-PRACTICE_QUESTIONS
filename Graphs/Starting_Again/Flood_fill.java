package Graphs.Starting_Again;

public class Flood_fill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return coloring(image, sr, sc, color, image[sr][sc]);
    }

    public static int[][] coloring(int[][] image, int sr, int sc, int color, int orig){
        if(image[sr][sc] == orig) image[sr][sc] = color;
        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        for(int idx=0;idx<4;idx++){
            int x = sr+dirX[idx];
            int y = sc+dirY[idx];

            if(possible(x,y,image, color, orig)){
                image = coloring(image, x, y, color, orig);
            }
        }
        return image;
    }

    public static boolean possible(int x, int y, int[][] image, int color, int orig){
        if(x<0 || x>=image.length || y<0 || y>=image[0].length || image[x][y] == color || image[x][y] != orig){
            return false;
        }
        return true;
    }

    public static void printImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test case 1: Basic flood fill
        int[][] image1 = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        
        System.out.println("Original image 1:");
        printImage(image1);
        
        int[][] result1 = floodFill(image1, 1, 1, 2);
        
        System.out.println("After flood fill (sr=1, sc=1, color=2):");
        printImage(result1);
        
        System.out.println();
        
        // Test case 2: Larger image
        int[][] image2 = {
            {0,0,0},
            {0,0,0}
        };
        
        System.out.println("Original image 2:");
        printImage(image2);
        
        int[][] result2 = floodFill(image2, 0, 0, 2);
        
        System.out.println("After flood fill (sr=0, sc=0, color=2):");
        printImage(result2);
        
        System.out.println();
        
        // Test case 3: Same color fill (should remain unchanged)
        int[][] image3 = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        
        System.out.println("Original image 3:");
        printImage(image3);
        
        int[][] result3 = floodFill(image3, 1, 1, 1);
        
        System.out.println("After flood fill with same color (sr=1, sc=1, color=1):");
        printImage(result3);
    }
}
