package Recursion;
import java.util.Scanner;
public class sumOfDigits {

    static int SOD(int n){
        if(n>=0 && n<=9){
            return n;
        }
        return SOD(n/10) + n%10;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(SOD(n));
    }
}
