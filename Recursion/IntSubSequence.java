package Recursion;

public class IntSubSequence {

    static void SumOfSubSequence(int[] arr ,int idx, int sum){
        if(idx >= arr.length){
            System.out.print(sum+" ");
            return;
        }
        SumOfSubSequence(arr,idx+1, sum+arr[idx]);
        SumOfSubSequence(arr, idx+1, sum);
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5};
        int sum =0;
        SumOfSubSequence(arr,0, sum);
    }
}
