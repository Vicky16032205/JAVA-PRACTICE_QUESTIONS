package Strings;

public class repeatStrings {
    public static void main(String[] args) {
        String s = "abcac";
        System.out.println(s.length());
        int n = 125;
        char ch ='a';
        System.out.println(findLength(s,n,ch));
    }

    public static int findLength(String s , int n , char ch) {
        int num = 0;
        int count = n/s.length();
        int rem = n%s.length();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ch){
                num++;
            }
        }

        num *= count;

        for(int i=0;i<rem;i++){
            if(s.charAt(i) == ch){
                num++;
            }
        }

        return num;
    }
}