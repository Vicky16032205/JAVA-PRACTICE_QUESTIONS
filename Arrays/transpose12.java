import java.util.*;
class transpose12{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter rows: ");
        int r =sc.nextInt();
        System.out.print("enter columns: ");
        int c =sc.nextInt();
        sc.close();
        int[][] nums = new int[r][c];
        System.out.println("Enter "+r*c+" elements");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println("Original array :  ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
        int r1 =c;
        int c1 = r;

        int[][] trans = new int[r1][c1];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                trans[i][j] = nums[j][i];
            }
        }
        System.out.println("Transposed array :  ");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                System.out.print(trans[i][j]+" ");
            }
            System.out.println();
        
        }
        System.out.println("transposed array");
        for(int i=0;i<r;i++){
            for(int j=i;j<c;j++){
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
    }
}
