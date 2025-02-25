package Stack;

import java.util.Stack;

public class the_celebrity_problem {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0} , {0,1,0} , {0,1,1}};
        int result = celebrity(mat);
        System.out.println(result);
    }
    
    public static int celebrity(int[][] mat){
        Stack<Integer> st = new Stack<>();
        int n = mat.length;

        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>1){
            int val1 = st.pop();
            int val2 = st.pop();

            if(mat[val1][val2] == 0) st.push(val1);
            else if(mat[val2][val1] == 0) st.push(val2);
        }
        if(st.isEmpty()) return -1;

        int potential = st.pop();

        for(int j=0;j<n;j++){
            if(j!=potential && mat[potential][j] == 1) return -1;
        }

        for(int i=0;i<n;i++){
            if(mat[i][potential] == 0) return -1;
        }

        
        return potential;
    }
}
