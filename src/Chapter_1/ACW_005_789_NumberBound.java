package Chapter_1;

import java.util.Scanner;

public class ACW_005_789_NumberBound {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int k = input.nextInt();
            int l = 0, r = n -1;
            while (l < r){
                int mid = l + r >> 1;
                if (arr[mid] < k) l = mid + 1;
                else r = mid;
            }
            if (arr[l] != k){
                System.out.println("-1 -1");
            }else {
                System.out.print(l + " ");
                l = 0;
                r = n - 1;
                while (l < r){
                    int mid = l + r + 1 >> 1;
                    if (arr[mid] <= k) l = mid;
                    else r = mid - 1;
                }
                System.out.print(l);
            }


        }

    }


}

/*
6 3
1 2 2 3 3 4
3
4
5
 */