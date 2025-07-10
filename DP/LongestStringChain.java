package DP;

import java.util.Arrays;

public class LongestStringChain {
    public static int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        Arrays.sort(words , (w1, w2)->Integer.compare(w1.length() , w2.length()));
        int maxi = 1;

        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(increasingPattern(words[i] , words[j]) && dp[i] < dp[j] +1){
                    dp[i] = 1 + dp[j];
                    maxi = Math.max(dp[i] , maxi);
                }
            }
        }
        return maxi;
    }

    public static boolean increasingPattern(String s, String t){
        if(s.length() != t.length()+1) return false;
        int i=0, j=0;
        boolean skip = false;
        while(i<s.length()){
            if(j<t.length() && s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                if(skip) return false;
                skip = true;
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println("Longest String Chain possible: " + longestStrChain(words));
    }
}
