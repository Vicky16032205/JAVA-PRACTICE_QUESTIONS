package PATTERN;
import java.util.Scanner;
public class start1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        sc.close();
        System.out.println("First Pattern");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Second Pattern");

        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Third Pattern");

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Fourth Pattern");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Fifth Pattern");
        for(int i=n;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Sixth Pattern");
        for(int i=n;i>0;i--){
            for(int j=0 ; j<i ; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Seventh Pattern");
        for(int i=n;i>0;i--){
            for(int j=1 ; j<=i ; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Eighth Pattern");
        for(int i=n;i>=1;i--){
            for(int j=n;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
                System.out.println();
            
        } 
        System.out.println();
        System.out.println("Ninth Pattern");
        for(int i=1;i<=n;i++){
            for(int j=n;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
                System.out.println();
            
        }  
        System.out.println();
        System.out.println("Tenth Pattern");
        for(int i=1;i<=n;i++){
            for(int j=n;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
                System.out.println();
        } 
        for(int i=n;i>=1;i--){
            for(int j=n;j>i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Eleventh Pattern");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>1;i--){
            for(int j=i;j>1;j--){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Twelfth Pattern");
        int k=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }
}




