import java.util.*;
class rotate90 {

    static void printMatrix(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void traverser(int[][] arr , int n){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("traversed array");
        printMatrix(arr, n);
    }

    static void reverseRows(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    static void rotate (int[][] arr , int n ){
        traverser(arr, n);
        System.out.println("rotated array : ");
        reverseRows(arr, n);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of array : ");
        int n = sc.nextInt();
        int[][] arr =new int[n][n];
        System.out.println("enter "+n*n+" elements here : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("original array");
        printMatrix(arr, n);

        rotate(arr, n);
        printMatrix(arr, n);

        sc.close();
    }
}