package Chapter_1;

import java.util.*;

public class ACW_017_2816_IsSubString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) arr1[i] = input.nextInt();
        for (int i = 0; i < m; i++) arr2[i] = input.nextInt();

        int arr1_index = 0, arr2_index = 0;
        boolean flag = false;
        while (arr2_index < m){
            if (arr1[arr1_index] == arr2[arr2_index]) {
                arr1_index++;
            }
            if (arr1_index == n) {
                flag = true;
                break;
            }
            arr2_index++;
        }

        if (flag) System.out.print("Yes");
        else System.out.print("No");
    }
}

/*
3 5
1 3 5
1 2 3 4 5

3 6
1 1 1
1 1 1 2 2 2
 */