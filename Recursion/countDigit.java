package Recursion;
import java.util.Scanner;
class countDigit {

    static int count(int n){
        if(n>=0 && n<=9){
            return 1;
        }
        return count(n/10)+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(count(n));
    }
}