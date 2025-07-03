package DP;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "acd";
        String str2 = "ced";
        System.out.println(printCommon(str1,str2));
    }

    public static int printCommon(String str1 , String str2){
        return recursive(str1.length()-1 , str2.length()-1 , str1 , str2);
    }

    public static int recursive(int idx1 , int idx2, String str1 , String str2){
        if(idx1 <0 || idx2 < 0) return 0;

        if(str1.charAt(idx1) == str2.charAt(idx2)) return 1 + recursive(idx1-1, idx2-1, str1, str2);
        return Math.max(recursive(idx1-1, idx2, str1, str2) , recursive(idx1, idx2-1, str1, str2));
    }
}
