package Stack;
import java.util.*;
public class min_bracket_remove {

    public static int minRemovalRequired(String s){
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                count++;
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    char top = st.peek();
                    if((ch == ')' && top =='(') ||
                        (ch == ']' && top =='[') ||
                        (ch == '}' && top =='{')
                    ) st.pop();
                }

                else continue;

            }
        }
        if(count == 0){
            return s.length();
        }
        return st.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int totalRemoved = minRemovalRequired(s);
        System.out.println(totalRemoved);
    }
}
