package Recursion;

public class isSorted {
    static boolean sorted(int[] arr , int idx){
        if(idx == arr.length) return true;
        if(arr[idx]<arr[idx-1]){
            return false;
        }
        return sorted(arr, idx+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,81,9};
        System.out.println(sorted(arr , 1)); 
    }
}