package Recursion;
import java.util.Scanner;
public class ReverseString {
    static String WordReverse(String s){
        if(s.length()==0){
            return "";
        }
        String smallAns = WordReverse(s.substring(1));
        return smallAns+ s.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(WordReverse(s));
    }
}
