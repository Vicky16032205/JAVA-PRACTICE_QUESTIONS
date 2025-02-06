import java.util.*;
class spiral{

    static void matrix(int[][] arr, int  r , int c){
        System.out.println("Original Array : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }



    static void spiral123( int[][] arr ,int r ,int c){
        int topRow=0 ,  rightCol = c-1 ,  bottomRow =r-1 ,  leftCol =0;
        int totalElements = 0;

        while(totalElements<r*c){
            //topRow ==> leftCol -> rightCol
            for(int j=leftCol;j<=rightCol && totalElements<r*c ;j++){
                System.out.print(arr[topRow][j]+" ");
                totalElements++;
            }
            topRow++;
            

            //rightCol ==> topRow -> bottomRow
            for(int i=topRow;i<=bottomRow && totalElements<r*c;i++){
                System.out.print(arr[i][rightCol]+ " ");
                totalElements++;
            }
            rightCol--;
            

            //bottomRow ==> rightCol -> leftCol
            for (int j = rightCol; j >= leftCol && totalElements < r * c; j--) {
                System.out.print(arr[bottomRow][j] + " ");
                totalElements++;
            }
            bottomRow--;


            //leftCol ==> bottomRow -> topRow
            for (int i = bottomRow; i >= topRow && totalElements < r * c; i--) {
                System.out.print(arr[i][leftCol] + " ");
                totalElements++;
            }
            leftCol++;


        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row size : ");
        int r = sc.nextInt();
        System.out.print("Enter column size : ");
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("enter "+ r*c + " elements : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        matrix(arr, r, c);
        System.out.println("Spiral Order:");
        spiral123(arr,r,c);
        sc.close();
        
    }

}