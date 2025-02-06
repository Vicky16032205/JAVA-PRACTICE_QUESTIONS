package Recursion;
import java.util.Scanner;
public class revString {
    static String reverse(String s ,int idx){
        if(idx == s.length()) return "";
        String smallAns = reverse(s, idx+1);
        return smallAns + s.charAt(idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string here : ");
        String s = sc.nextLine();
        sc.close();
        String rev = reverse(s, 0);
        if(rev.equals(s)){
            System.out.printf("%s is Palindrome in nature " , s);
        }
        else{
            System.out.printf("%s is Not Palindrome in nature ", s);
        }

    }
}