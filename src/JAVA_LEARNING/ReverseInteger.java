package JAVA_LEARNING;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        int y = -123;
        System.out.println(reverse(x));
        System.out.println(reverse(y));
    }

    public static int reverse(int x){
        int res = 0;

        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            if(res > (Integer.MAX_VALUE - pop) / 10 || -(res*10 + pop) > Integer.MAX_VALUE) return 0;
            res = res*10 + pop;
//            System.out.println(res);
        }
        return res;
    }
}
