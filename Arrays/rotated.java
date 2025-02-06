import java.util.Arrays;
public class rotated {
    static int[] rotateArr(int arr[], int d) {
            int l = arr.length;
            int n = d%arr.length;
            int[] rotated = new int[l];
            int j = 0;
            for(int i=l-n;i<l;i++){
                rotated[j++] = arr[i];
            }
            for(int i=0;i<l-n;i++){
                rotated[j++] = arr[i];
            }
            return rotated;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int d=2;
        System.out.println(Arrays.toString(rotateArr(arr, d))); 
    }
}