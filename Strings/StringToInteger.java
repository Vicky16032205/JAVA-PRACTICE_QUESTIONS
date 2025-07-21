package Strings;

public class StringToInteger {
    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean numFlag = false, signFlag = false, space = false;
        int sign = 1;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ') {
                if(numFlag || (signFlag&&space)) break;
                space = true;
                continue;
            }
            else if(s.charAt(i) == '-'||s.charAt(i) == '+'){
                if(numFlag && !signFlag) break;
                if(signFlag && (space)) break;
                if(signFlag) break;
                signFlag = true;
                sign = (s.charAt(i) == '-')?-1:1;
            }
            else if(Character.isDigit(s.charAt(i))){
                numFlag = true;
                sb.append(s.charAt(i));
            }
            else{
                if(!numFlag) return 0;
                break;
            }
        }

        if(sb.length()==0) return 0;
        try {
            int result = Integer.parseInt(sb.toString());
            return result * sign;
        } 
        catch (NumberFormatException e) {
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println(myAtoi(s));
        // s can be "42", " -042", "0-1", "words and 987", "+-12", etc.,.
    }
}
