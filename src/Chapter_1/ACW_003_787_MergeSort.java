package Chapter_1;

import java.util.Scanner;

public class ACW_003_787_MergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        merge_sort(num, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }

    }

    public static void merge_sort(int q[], int left, int right){
        if (left >= right) return;
        int mid = left + right >> 1;
        merge_sort(q, left, mid);
        merge_sort(q, mid+1, right);

        int[] p = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right){
            if (q[i] <= q[j]) {
                p[idx++] = q[i++];
            } else{
                p[idx++] = q[j++];
            }
        }
        while (j <= right){
            p[idx++] = q[j++];
        }
        while (i <= mid){
            p[idx++] = q[i++];
        }

        for (int x = left, y = 0; x <= right; x++,y++) {
            q[x] = p[y];
        }
    }
}


/*
5
3 1 2 4 5

30
128 294 133 295 175 8 232 248 241 164 11 60 238 133 291 116 6 67 98 67 196 260 181 160 83 160 90 153 233 216
 */