package DP;

public class PalindromePartitionIVOptimized {
    public static void main(String[] args) {
        String s = "abcbdd";
        System.out.println(checkPartitioning(s));
    }

    public static boolean checkPartitioning(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][3];
        boolean[][] pal = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) pal[i][j] = true;
                    else pal[i][j] = pal[i + 1][j - 1];
                }
            }
        }

        return partition(0, 0, s, dp, pal);
    }

    public static boolean partition(int cut, int i, String s, Boolean[][] dp, boolean[][] pal){
        if (i >= s.length()) return false;
        if (cut == 2) return pal[i][s.length() - 1];

        if (dp[i][cut] != null) return dp[i][cut];

        for (int j = i; j < s.length(); j++) {
            if (pal[i][j]) {
                if (partition(cut + 1, j + 1, s, dp, pal)) {
                    return dp[i][cut] = true;
                }
            }
        }

        return dp[i][cut] = false;
    }
}
