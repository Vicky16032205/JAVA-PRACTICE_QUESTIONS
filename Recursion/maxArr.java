package Recursion;

public class maxArr {
    static int MaxArr(int[] arr , int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        int smallAns = MaxArr(arr,idx+1);

        return Math.max(smallAns , arr[idx]);
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,6,7,8,9};
        System.out.println(MaxArr(arr,0));
    }
}
