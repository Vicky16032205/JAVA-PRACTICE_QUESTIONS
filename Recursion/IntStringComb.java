package Recursion;

public class IntStringComb {
        static void Comb(String s , String[] kp , String res){
            if(s.length() == 0){
                System.out.print(res + " ");
                return;
            } 
            int num = s.charAt(0) - '0';
            String currChoice = kp[num];

            for(int i=0;i<currChoice.length() ; i++){
                Comb(s.substring(1) , kp , res + currChoice.charAt(i));
            }
        }
    public static void main(String[] args) {
        String s = "34";
        String[] kp = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Comb(s , kp , "");
    }
}
