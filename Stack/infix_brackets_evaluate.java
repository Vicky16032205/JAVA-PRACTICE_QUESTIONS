package Stack;

import java.util.Stack;

public class infix_brackets_evaluate {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = (int) ch;

            if(ascii >=48 && ascii <=57){
                val.push(ascii-48);
            }
            else if(op.isEmpty() || ch == '(' || op.peek() == '('){
                op.push(ch);
            }
            else if(ch == ')'){
                while(op.peek() != '('){
                    int v1 = val.pop();
                    int v2 = val.pop();
                    char x = op.pop();

                    if(x == '+') val.push(v2+v1);
                    else if(x == '-') val.push(v2-v1);
                    else if(x == '*') val.push(v2*v1);
                    else if(x == '/') val.push(v2/v1);
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-'){
                    int v1 = val.pop();
                    int v2 = val.pop();

                    if(op.peek() == '+') val.push(v2+v1);
                    else if(op.peek() == '-') val.push(v2-v1);
                    else if(op.peek() == '*') val.push(v2*v1);
                    else if(op.peek() == '/') val.push(v2/v1);
                    op.pop();

                    op.push(ch);
                }
                else{
                    if(ch == '*' || ch == '/'){
                        if(op.peek() == '*' || op.peek() == '/'){
                            int v1 = val.pop();
                            int v2 = val.pop();
                            if(op.peek() == '*') val.push(v2*v1);
                            else if(op.peek() == '/') val.push(v2/v1);

                            op.pop();
                        }
                    }

                    op.push(ch);
                }
            }
        }

        while(val.size()>1){
            int v1 = val.pop();
            int v2 = val.pop();
            char x = op.pop();

            if(x == '+') val.push(v2+v1);
            else if(x == '-') val.push(v2-v1);
            else if(x == '*') val.push(v2*v1);
            else if(x == '/') val.push(v2/v1);
        }

        System.out.println(val.pop());
    }
}
