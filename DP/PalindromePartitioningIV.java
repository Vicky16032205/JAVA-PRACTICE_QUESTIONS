package DP;

public class PalindromePartitioningIV {
    public static void main(String[] args) {
        String s = "abcbdd";
        System.out.println(checkPartitioning(s));
    }

    public static boolean checkPartitioning(String s) {
        Boolean[][] dp = new Boolean[s.length()+1][3];
        return partition(0, 0, s, dp);
    }

    public static boolean partition(int cut, int i, String s, Boolean[][] dp){
        if(dp[i][cut] != null) return dp[i][cut];

        if(i == s.length()-1 && cut != 2) return false;
        if(cut == 2){
            return i!=s.length() && palindrome(i, s.length()-1, s);
        }

        for(int j=i;j<s.length();j++){
            if(palindrome(i, j, s)){
                boolean ans = partition(cut+1, j+1, s, dp);
                dp[i][cut] = ans;
                if(ans) return true;
            }
        }
        return dp[i][cut] = false;
    }

    public static boolean palindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}