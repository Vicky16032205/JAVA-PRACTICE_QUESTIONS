package BackTracking;

import java.util.ArrayList;

public class permutation_backtracking {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        // permutations possible : (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), (3,2,1).

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] isVis = new boolean[arr.length];
        ArrayList<Integer> ans = new ArrayList<>();

        MakePermutations(arr,isVis,ans,res);

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    private static void MakePermutations(int[] arr, boolean[] isVis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
        if(ans.size()== arr.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(isVis[i]) continue;
            ans.add(arr[i]);
            isVis[i] = true;
            MakePermutations(arr,isVis,ans,res);
            isVis[i] = false;
            ans.remove(ans.size()-1);
        }
    }
}
