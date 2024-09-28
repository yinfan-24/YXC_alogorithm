package JAVA_LEARNING;

public class StringToInteger {
    public static void main(String[] args) {
        String str1 = "42";
        String str2 = "   -42";
        String str3 = "4193 with words";
        String str4 = "91283472332";
        System.out.println(parseInt(str1));
        System.out.println(parseInt(str2));
        System.out.println(parseInt(str3));
        System.out.println(parseInt(str4));
    }

    public static int parseInt(String str){
        int res = 0;
        int sign = 1;
        int index = 0;

//        去掉空格
        while (index < str.length() && str.charAt(index) == ' ' ) index++;

        if (index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()){
            int digit = str.charAt(index) - '0';
//            数字检查
            if(digit < 0 || digit > 9) break;
//            溢出检查
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10))
            {
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }

        return sign * res;
    }
}
