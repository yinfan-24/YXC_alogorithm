package Chapter_1;

import java.util.*;

import static java.lang.Math.max;

public class ACW_015_799_NoRepeatSubsequnce_Acwing_799 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int[] arr_dict = new int[100010];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int l = 0, r = 0;
        int max_length = 0;

        while(r < n){
//            没碰到过，右指针继续扫，登记
            if (arr_dict[arr[r]] == 0){
                arr_dict[arr[r]] += 1;
                max_length = max_length < r - l + 1 ? r - l + 1 : max_length;
                r += 1;
            }
//            碰到了就重置
            else {
//                arr_dict = new int[100010];
//                System.out.println("在第" + (r+1) + "位碰到了重复的数字：" + arr[r]);
//                System.out.println( "此时最长长度为：" + max_length);
                arr_dict[arr[l]] = 0;
                l++;
            }
        }
        System.out.print(max_length);
    }
}

/*
5
1 2 2 3 5

10
9 3 6 9 5 10 1 2 3 9


100
16 39 7 29 34 14 36 16 37 38 6 3 11 3 39 9 25 20 14 26 4 23 17 30 14 25 24 16 30 4 35 13 30 13 30 37 0 16 21 5 28 9 24 5 28 3 21 16 28 23 29 23 23 22 13 15 32 10 39 16 4 8 6 38 33 12 29 38 39 33 16 30 35 39 36 29 7 39 2 0 4 14 34 37 30 21 2 12 39 33 13 17 1 39 23 40 37 28 30 22

 */
