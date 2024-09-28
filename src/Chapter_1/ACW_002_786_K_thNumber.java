package Chapter_1;

import java.util.*;

public class ACW_002_786_K_thNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        kth_number(num,0, n-1);
        System.out.print(num[k-1] + "\n");
//        for (int i = 0; i < n; i++) {
//            System.out.print(num[i] + " ");
//        }
        input.close();
    }

    public static void kth_number(int[] q, int left, int right){
        if (left >= right) return;
        int ref = q[left + right >> 1];
        int x = left - 1, y = right + 1;
        while (x < y)
        {
            while (q[++x] < ref);
            while (q[--y] > ref);
            if (x < y){
                int tmp = q[x];
                q[x] = q[y];
                q[y] = tmp;
            }
        }

        kth_number(q, left, y);
        kth_number(q, y + 1, right);

    }

}


/*
30 1
128 294 133 295 175 8 232 248 241 164 11 60 238 133 291 116 6 67 98 67 196 260 181 160 83 160 90 153 233 216
 */