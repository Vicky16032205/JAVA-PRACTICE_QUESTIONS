package Recursion;
import java.util.Scanner;
public class power {

    static int pow(int p , int q){
        if(q==0) return 1;

        return pow(p,q-1) * p ;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();
        System.out.println(pow(p , q));
    }
}
