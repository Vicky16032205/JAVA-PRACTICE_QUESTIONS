import java.util.*;

public class prefixSum {

    static void matrix(int[][] arr , int r , int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row : ");
        int r = sc.nextInt();
        System.out.print("Enter column : ");
        int c = sc.nextInt();
        int[][] arr =new int[r][c];
        System.out.println("Enter "+r*c+" elements : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Original Array : ");
        matrix(arr, r, c);
        System.out.println("Enter values of l1 , r1, l2 and r2 here: ");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        System.out.println("Prefix Sum of Arrays");
        preSum(arr);
        matrix(arr, r, c);
        System.out.print("Rectangle Sum for l1, r1, l2 , r2 is : "+  realSum(arr, l1, r1, l2, r2));
        sc.close();
    }  

    static void preSum(int[][] arr){
        int r = arr.length;
        int  c = arr[0].length;
        for(int i=0 ; i<r ; i++){
            for(int j=1;j<c ; j++){
                arr[i][j] += arr[i][j-1] ;
            }
        }
    }
    static int realSum(int[][] arr , int l1, int r1 , int l2 , int r2){
        int sum =0 ;
        preSum(arr);
        for(int i= l1 ; i<=l2 ; i++){
            if(r1>=1){
                sum += arr[i][r2] - arr[i][r1-1];
            }
            else{
                sum += arr[i][r2];
            }  
        }
        return sum;
    }
}