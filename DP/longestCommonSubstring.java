package DP;

public class longestCommonSubstring {
    static int ans =0;
    public static void main(String[] args) {
        String s = "vicky";
        String t = "vickyg";

        System.out.println(common(s.length()-1 , t.length()-1 , s , t , 0));
    }

    public static int common(int idx1, int idx2,  String s, String t, int count){
        if(idx1 <0 || idx2<0) return ans;
        if(s.charAt(idx1) == t.charAt(idx2)){
            count += 1;
            ans = Math.max(ans , count);
            return common(idx1-1, idx2-1, s, t, count);
        }
        else{
            return Math.max(common(idx1-1, idx2, s, t, 0) , common(idx1, idx2-1, s, t, 0));
        }
    }
}
