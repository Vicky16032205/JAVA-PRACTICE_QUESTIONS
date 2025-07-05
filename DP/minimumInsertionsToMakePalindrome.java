package DP;

public class minimumInsertionsToMakePalindrome {
    public static void main(String[] args) {
        String s = "abcaa";
        String t = new StringBuilder(s).reverse().toString();

       int ans = recursive(s.length()-1, t.length()-1 , s ,t);
       System.out.println("Minimum Insertions required = "+ (s.length()- ans));
    }

    public static int recursive(int idx1 , int idx2, String s , String t){
        if(idx1 < 0 || idx2 <0) return 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            return 1 + recursive(idx1-1, idx2-1, s, t);
        }
        return Math.max(recursive(idx1-1, idx2, s, t) , recursive(idx1, idx2-1, s, t));
    }
}
