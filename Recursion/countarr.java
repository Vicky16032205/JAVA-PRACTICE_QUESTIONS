package Recursion;

public class countarr {
    static boolean arrPresent(int[]arr , int target , int idx){
        if(idx == arr.length) return false;
        if(target == arr[idx]){
            return true;
        }
        return arrPresent(arr, target, idx+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 41;
        System.out.println(arrPresent(arr, target, 0));
    }
}