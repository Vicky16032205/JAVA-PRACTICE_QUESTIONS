package Strings;

import java.util.HashSet;

public class longestSubstringWithNoRepeatition {
    public static void main(String[] args) {
        String s = "abcabcbb";
        // s can be "", " ", "bbbb", "pwwkew", "aab" anything.

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxi = 0;
        HashSet<Character> set  = new HashSet<>();
        int left = 0, right =0;

        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxi = Math.max(maxi , right-left+1);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxi;
    }
}
