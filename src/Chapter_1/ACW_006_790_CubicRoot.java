package Chapter_1;

import java.util.*;


public class ACW_006_790_CubicRoot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Double n = input.nextDouble();
        Double l = -1000.;
        Double r = 1000.;
        while (r - l > 1e-8){
            Double mid = (l + r) / 2;
            if (mid * mid * mid < n) l = mid;
            else r = mid;
        }
        System.out.printf("%.6f", l);
    }
}
