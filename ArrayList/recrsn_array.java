package ArrayList;

import java.util.ArrayList;

public class recrsn_array {
    static ArrayList<Integer> Indices(int[] arr , int idx , int target){
        ArrayList<Integer> ans = new ArrayList<>();
        if(idx >= arr.length) return ans;
        if(arr[idx] == target){
            ans.add(idx);
        }
        ArrayList<Integer> smallAns = Indices(arr, idx+1, target);
        ans.addAll(smallAns);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4,4,4,4,4};
        int target = 4;
        System.out.println(Indices(arr, 0, target)); 
    }
}
