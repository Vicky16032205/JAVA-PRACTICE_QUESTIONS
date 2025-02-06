import java.util.*;
public class add_matrix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many matrices you need to add : ");
        int num = sc.nextInt();
        int n=1;
        int[][] sumMatrix = null;
        int rows = 0, cols = 0;
        while(n<=num){
            System.out.println("enter arr"+n+" here :");
            System.out.print("enter row size here : ");
            int r = sc.nextInt();
            System.out.print("enter column size : ");
            int c = sc.nextInt();

            if (n == 1) {
                rows = r;
                cols = c;
                sumMatrix = new int[rows][cols];
            } 
            else if (r != rows || c != cols) {
                System.out.println("Error: All matrices must have the same dimensions.");
                return;

            }


            System.out.print("enter total "+ r*c + "elements : ");
            int[][] arr = new int[r][c];
            for(int i = 0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            sc.close();
            if (sumMatrix == null) {
                sumMatrix = new int[r][c];
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sumMatrix[i][j] += arr[i][j];
                }
            }

            for(int i=0;i<r;i++){
                for(int j =0;j<c;j++){
                    System.out.print(sumMatrix[i][j] + " ");
                }
                System.out.println();
            }
            n++;
        }


    }
}
