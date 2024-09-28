package Chapter_1;

import java.util.Scanner;

public class ACW_016_800_TargetaOfArrayElementsAnd {

    public static void main(String[] args) {
        int n, m, x;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        x = input.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) arr1[i] = input.nextInt();
        for (int i = 0; i < m; i++) arr2[i] = input.nextInt();
        int i = 0, j = m-1;
        while (j >= 0 && i < n){
            if (arr1[i] + arr2[j] > x){
                j--;
            }
            else if(arr1[i] + arr2[j] < x){
                i++;
            }
            else{
                System.out.print(i + " " + j);
                return;
            }
        }

    }
}


/*
4 5 6
1 2 4 7
3 4 6 8 9
 */