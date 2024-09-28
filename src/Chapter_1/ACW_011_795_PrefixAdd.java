package Chapter_1;

import java.util.*;

public class ACW_011_795_PrefixAdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n+1];
        long[] res = new long[n+1];
        for (int i = 1; i < n+1; i++){
            arr[i] = input.nextInt();
            res[i] = arr[i] + res[i-1];
        }

        for (int i = 0; i < m; i++) {
            int l = input.nextInt();
            int r = input.nextInt();

            System.out.println(res[r] - res[l-1]);
        }
    }

//    public static long[] prefix_add(int[] arr){
//        long[] res = new long[arr.length];
//        for (int i = 1; i < arr.length; i++) {
//            res[i] = arr[i] + res[i-1];
//        }
//        return res;
//    }

}


/*
5 3
2 1 3 6 4
1 2
1 3
2 4
 */