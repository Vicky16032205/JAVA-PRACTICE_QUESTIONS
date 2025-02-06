package Recursion;
public class array {
    static void printArr(int[] arr , int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        printArr(arr , idx+1);
        
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6};
        printArr(arr, 0); 
    }
}