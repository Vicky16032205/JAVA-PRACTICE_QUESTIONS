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


    public static int myAtoi2(String s) {
        int n= s.length();
        int i=0, sign =1;
        long res = 0;

        while(i<n && s.charAt(i) ==' '){
            i++;
            continue;
        }

        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i)=='-') ? -1: 1;
            i++;
        }

        while(i<n && Character.isDigit(s.charAt(i))){
            res = res*10 + (s.charAt(i)-'0');
            if(sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return (int)(res*sign);
    }

    public static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println(myAtoi(s));
        System.out.println(myAtoi2(s));
        // s can be "42", " -042", "0-1", "words and 987", "+-12", etc.,.
    }
}
