package Recursion;

public class IncreaseString {

    static void SelectionSortString(String[] s){
        int n = s.length;
        for(int i=0;i<n;i++){
            int min_index = i;
            for(int j=i+1 ; j<n ; j++){
                if(s[j].compareTo(s[min_index]) < 0){
                    min_index = j;
                }
            }
            String temp = s[i];
            s[i] = s[min_index];
            s[min_index] = temp;
        }
        
    }

    public static void main(String[] args) {
        String[] s = {"kiwi" , "mango" , "apple" , "papaya" , "guava"};
        SelectionSortString(s);
        for(String nums:s){
            System.out.println(nums + " ");
        }
    }
}
