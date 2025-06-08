package BackTracking;

import java.util.ArrayList;

public class TotalPermutations {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> res = new ArrayList<>();

        findPermutations(str,res,"");

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    private static void findPermutations(String str, ArrayList<String> res, String s) {
        if(str.equals("")){
            res.add(s);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String leftSide = str.substring(0, i);
            String rightSide = str.substring(i+1);

            String ans = leftSide+rightSide;
            findPermutations(ans, res, s+ch);
        }
    }
}
