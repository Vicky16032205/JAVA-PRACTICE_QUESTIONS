package GFG_160_Days_Problems;

public class day_31 {

    static int findPeakElements(int[] arr){
        int n = arr.length;
        int st = 0;
        int end = n-1;
        while(st<=end){
            int mid = st+(end-st)/2;

            if((mid ==0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid+1]<arr[mid])){
                return arr[mid];
            }

            if(arr[mid]< arr[mid+1]){
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }


    // main function to find peak element .
    public static void main(String[] args) {
        int arr[] = {6,5,4,3,2,1};
        int n = findPeakElements(arr);
        System.out.println(n);
    }
}


// In this question we have to find peak element such that element before and after the number should be less then it , i.e.,
//  arr[i] > arr[i-1] && arr[i] > arr[i+1].

// If no element exist in the array that satisfy this property then return the element which should be present at first or last 
// index as element at -1 index is given as (-infinity) and element at last is also (-infinity) .

// we have to return the element which satisfy this property.