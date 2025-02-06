package Sorting_Algorithms;
public class BubbleSort {
    
    static void bubble(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            boolean flag = false;
            for(int j=0 ; j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,1,2,3,4,5};
        bubble(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
