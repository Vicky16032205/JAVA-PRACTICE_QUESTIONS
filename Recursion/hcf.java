package Recursion;
import java.util.Scanner;
public class hcf {
    static int GCD(int x,int y){
        if(y==0) return x;
        return GCD(y,x%y);
    }

    static int LCM(int x,int y){
        int gcd = GCD(x, y);
        int lcm = (x*y)/gcd;
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(GCD(x,y));
        System.out.println(LCM(x, y));
    }
}