package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class triangleProb {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int result = minimumTotal(triangle);
        System.out.println("Minimum path sum: " + result); // Output should be 11
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(triangle.get(i).size(), null));
            dp.add(row);
        }
        return mini(triangle, 0,0,dp);
    }

    public static int mini(List<List<Integer>> triangle, int sr, int sc, List<List<Integer>> dp){
        if(sr == triangle.size()-1) return triangle.get(sr).get(sc);
        if(dp.get(sr).get(sc) != null) return dp.get(sr).get(sc);
        int down = mini(triangle, sr+1,sc,dp);
        int diag = mini(triangle, sr+1,sc+1,dp);

        int result = triangle.get(sr).get(sc) + Math.min(down,diag);
        dp.get(sr).set(sc,result);
        return result;
    }
}
