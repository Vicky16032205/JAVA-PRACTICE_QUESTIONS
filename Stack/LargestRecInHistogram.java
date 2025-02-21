package Stack;

import java.util.*;

public class LargestRecInHistogram {

    public static int valueHistogram(int[] height){
        int n = height.length;
        int[] NSE = new int[n];
        int[] PSE = new int[n];

        int maxValue = 0;
        int val = 0;
        
        Stack<Integer> st = new Stack<>();

// We will find next smaller elements from here on .

        st.push(n-1);
        NSE[n-1] = n;
        for(int i=n-2;i>=0;i--){
            NSE[i] = n;
            if(height[i] > height[st.peek()]){
                NSE[i] = st.peek();
                st.push(i);
            }
            else{
                while(!st.isEmpty() && (height[i] <= height[st.peek()])){
                    st.pop();
                }
                if(!st.isEmpty()){
                    NSE[i] = st.peek();
                }
                st.push(i);
            }
        }

        while(!st.isEmpty()){
            st.pop();
        }

// We will find previous smaller elements from here on .
        Arrays.fill(PSE , -1);
        st.push(0);

        st.push(0);
        Arrays.fill(PSE , -1);
        for(int i=1;i<n;i++){
            if(height[i] > height[st.peek()]){
                PSE[i] = st.peek();
                st.push(i);
            }
            else{
                while(!st.isEmpty() && (height[i] <= height[st.peek()])){
                    st.pop();
                }
                if(!st.isEmpty()){
                    PSE[i] = st.peek();
                }
                st.push(i);
            }
        }


// from now on we will be calculating values of every index elements checking if they make it larger or not .

        for(int i=0;i<n;i++){
            val = height[i]*(NSE[i] - PSE[i] - 1);
            if(maxValue < val){
                maxValue = val;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] height = {5,2,4,6,3,5};
        System.out.println("Largest rectangle in histogram has value : " + valueHistogram(height));
    }
}
