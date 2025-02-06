public class Book_allocation {
    public static boolean isDivPossible(int[] arr , int k , int mid){
        int countStudents = 1;
        int maxPages = 0;

        for(int i=0;i<arr.length;i++){
            if(maxPages > mid){
                return false;
            }

            if(arr[i]+maxPages <= mid){
                maxPages += arr[i];
            }
            else{
                countStudents++;
                maxPages= arr[i];
            }
        }
        return countStudents<=k;
    }

    public static int findPages(int[] arr , int k){
        if(k>arr.length) return -1;
        int highest_value = 0;
        int total_sum = 0;
        for(int i=0;i<arr.length;i++){
            total_sum += arr[i];
            highest_value = Math.max(arr[i] , highest_value);
        }
        int ans =0;
        int st = highest_value;
        int end = total_sum;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(isDivPossible(arr,k,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        int k = 2;
        int n= findPages(arr,k);
        System.out.println(n);
    }
}
