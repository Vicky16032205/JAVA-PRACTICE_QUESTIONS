package Recursion;
import java.util.*;
public class Palindrome2 {
    static boolean Reverse(String s , int l , int r){
        if(l>=r) return true;
        return (s.charAt(l) == s.charAt(r) && Reverse(s, l+1, r-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(Reverse(s,0,s.length()-1));
    }
}