import java.util.*;
public class mul_mat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter matrix here : ");
        System.out.print("enter number of rows here :");
        int r1 = sc.nextInt();
        System.out.print("enter number of columns here: ");
        int c1 = sc.nextInt();
        int[][] arr = new int[r1][c1];
        System.out.println("enter a total of "+r1*c1+" elements : ");
        for(int i = 0;i<r1;i++){
            for(int j=0;j<c1;j++){
                arr[i][j] = sc.nextInt();
            }
        }


        System.out.println("enter matrix here : ");
        System.out.println("enter number of rows here :");
        int r2 = sc.nextInt();
        System.out.println("enter number of columns here: ");
        int c2 = sc.nextInt();
        System.out.println("enter a total of "+r2*c2+"elements : ");
        int[][] arr2 = new int[r2][c2];
        for(int i = 0;i<r2;i++){
            for(int j=0;j<c2;j++){
                arr2[i][j] = sc.nextInt();
            }
        }

        sc.close();
        System.out.println("Matrix1");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
               
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Matrix2");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }


        if(c1!=r2){
            System.out.println("columns of first matrix doesn't match with row of second matrix ");
            return;
        }
        int[][] mul = new int[r1][c2];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                for(int k=0;k<c1;k++){
                    mul[i][j] += arr[i][k] * arr2[k][j]; 
                }
            }
        }
        System.out.println("Multiplied Matrix : ");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
        }
    }
}