import java.util.*;

public class matrix{
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        System.out.print("Rows here : ");
        int r =sc.nextInt();
        System.out.print("Columns here : ");
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Enter total " + r*c+" elements here : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = sc.nextInt();
            }

        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
        
    }
}