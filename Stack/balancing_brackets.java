package Stack;

import java.util.*;

public class balancing_brackets {

    public static boolean vaildOrNot(String s){
        if(s.length() <= 1) return false;
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            
            else{
                char top = st.pop();
                if(ch ==')' && top != '('||
                    ch ==']' && top != '[' ||
                    ch =='}' && top != '{' 
                ) return false;
            }

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    boolean bool = vaildOrNot(s);
    System.out.println(bool);
    sc.close();
    }


}
