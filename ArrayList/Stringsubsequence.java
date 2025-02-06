package ArrayList;

import java.util.ArrayList;

public class Stringsubsequence {
    
    static ArrayList<String> sequence(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.length() == 0){
            ans.add("") ;
            return ans;
        }
        char curr = s.charAt(0);
        ArrayList<String> smallAns = sequence(s.substring(1));
        for(String ss:smallAns){
            ans.add(ss);
            ans.add(curr+ss) ;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(sequence(s));
    }
}
