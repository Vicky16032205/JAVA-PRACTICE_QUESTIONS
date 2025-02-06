package Recursion;

public class AllIndex {
    static void allIndexPresent(int[] arr , int idx , int target){
        if(idx >= arr.length) {
            return;
        }
        if(arr[idx] == target){
            System.out.print(idx+" ");
        }
        allIndexPresent(arr, idx+1, target);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,4,4,6,4,8,4};
        int target = 4;
        System.out.println("Your target element is : "+target);
        allIndexPresent(arr , 0 , 4);
    }
}