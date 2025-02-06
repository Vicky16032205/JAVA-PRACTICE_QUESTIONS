package Recursion;

public class SumArr {
    static int SumOfArray(int[] arr , int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        return SumOfArray(arr, idx+1) + arr[idx];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,10};
        System.out.println(SumOfArray(arr, 0));
    }
}
