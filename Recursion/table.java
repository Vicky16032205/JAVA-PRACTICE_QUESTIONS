package Recursion;
import java.util.Scanner;
public class table {
    static int table2(int n,int k){
        if(k==1){
            return n;
        }
        System.out.println(table2(n, k-1));
        return n*k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(table2(n, k));
    }
}