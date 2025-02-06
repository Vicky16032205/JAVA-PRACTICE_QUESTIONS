import java.util.Arrays;
public class Perm_of_num{

    // swapping of number is being done here.
    static void swap(int[] arr , int st , int end){
        while(st<end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }


    // Function for returning the next permutation.
    static int[] find_permutation(int[] arr){
        int n = arr.length;
        int i = n-2;


        // Finding the smallest descending element from the last or right end side .
       while(i>=0 && arr[i] >= arr[i+1]){
        i--;
       }


        // after that we find the number that is just bigger then the smallest number
        if(i>=0){
            int j = n-1;
            while(arr[j] <= arr[i]){
                j--;
            }
            // after we swap those two numbers.
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        // At the end we reverse the array till last from the element we swapped .
        swap(arr, i+1, n-1);


        // returning the array .
        return arr;
    }


    // MAIN METHOD .
    public static void main(String[] args) {
        int[] arr = {5};
        System.out.println(Arrays.toString(find_permutation(arr)));
    }
}