package Hard_Topics;

public class UnreachableElements_Kumar_K {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] mat = {
                    {1,2,3,4},
                    {-1,-1,-1,-1},
                    {5,6,7,8}
                };
        int count = 0;
        int minus = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == -1) minus++;
            }
        }

        if(minus == 0){
            System.out.println(0);
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == -1) continue;
                int reachable = Reachable(i,j,mat,new boolean[n][m]);
                count += (n*m - minus - reachable);
            }
        }
        System.out.println("Total unreachable states from each indices = "+(count-minus));
    }

    private static int Reachable(int i, int j, int[][] mat, boolean[][] vis) {
        vis[i][j] = true;
        int count = 1;

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        for(int idx = 0;idx<4;idx++){
            int X = i + dirX[idx];
            int Y = j + dirY[idx];
            if(unReachable(X, Y, mat, vis)){
                count += Reachable(X, Y, mat, vis);
            }
        }
        return count;
    }

    private static boolean unReachable(int i, int j, int[][] mat, boolean[][] vis){
        int n = mat.length;
        int m = mat[0].length;
        if(i<0 || i>n-1 || j<0 || j>m-1 || mat[i][j] == -1 || vis[i][j]) return false;
        return true;
    }
}
