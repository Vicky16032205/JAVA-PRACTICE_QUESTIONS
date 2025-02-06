package GFG_160_Days_Problems;

public class day_35 {

    static int find_Element_At_K(int[] arr , int k){
        if(k<arr[0]){
            return k;
        }
        int st =0;
        int end = arr.length-1;

        while(st<=end){
            int mid = st+(end-st)/2;

            int elementAtMid = arr[mid] - (mid+1);
            if(elementAtMid > k){
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        int missingUptoEnd = arr[end] - (end+1);

        return arr[end] + (k - missingUptoEnd);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 10;
        int n = find_Element_At_K(arr,k);
        System.out.println(n);
    }
}