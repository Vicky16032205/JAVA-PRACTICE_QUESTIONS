package Recursion;

public class subsequence2 {

    static void SSQ(String s , String currStr){
        if(s.length() == 0){
            System.out.print(currStr+" ");
            return ;
        }
        char curr = s.charAt(0);
        String remString = s.substring(1);
        SSQ(remString, currStr +curr);
        SSQ(remString, currStr);
    }

    public static void main(String[] args) {
        SSQ("abc", "");
    }
}