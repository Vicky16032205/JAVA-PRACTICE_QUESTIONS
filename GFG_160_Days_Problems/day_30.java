package GFG_160_Days_Problems;

public class day_30 {
    static int findNum(int[] arr , int key){
        int n = arr.length;
        int st = 0 ;
        int end = n-1;
        while(st<=end){
            int mid = st+(end-st)/2;

            if(arr[mid] == key) return mid;

            else if(arr[st] <= arr[mid]){
                if(arr[st] <= key && arr[mid] > key){
                    end = mid-1;
                }
                else{
                    st = mid+1;
                }
            }

            else{
                if(key> arr[mid] && arr[end] >= key){
                    st = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10,1,2,3,4};
        int key = 51;
        int m = findNum(arr, key);
        System.out.println(m);
    }
}
