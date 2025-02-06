import java.util.*;

public class inorderspiral {
    static void matrix(int[][] arr , int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] inorderspiral1(int n){
        int[][] arr = new int[n][n];
        int rightCol = n-1 , leftCol =0 , bottomRow = n-1 ,topRow = 0;
        int curr = 1;
        while(curr<=n*n){
            //topRow==> leftCol --> rightCol
            for(int j=leftCol ; j<=rightCol ; j++){
                arr[topRow][j] = curr++;
            }
            topRow++;

            //rightCol==> topRow --> bottomRow
            for(int i=topRow ; i<=bottomRow ; i++){
                arr[i][rightCol] = curr++;
            }
            rightCol--;


            //bottomRow==> rightCol --> leftCol
            for(int j=rightCol ; j>=leftCol ; j--){
                arr[bottomRow][j] = curr++;
            }
            bottomRow--;


            //leftCol==> bottomRow --> topRow
            for(int i=bottomRow ; i>=topRow ; i--){
                arr[i][leftCol] = curr++;
            }
            leftCol++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number here for printing the spiral order : ");
        int n = sc.nextInt();
        int [][] arr = inorderspiral1(n);
        matrix(arr, n);
        sc.close();
    }
}