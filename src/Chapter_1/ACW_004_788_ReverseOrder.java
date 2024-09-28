package Chapter_1;
import java.util.*;

public class ACW_004_788_ReverseOrder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        System.out.print(merge_sort(num, 0, n-1));
        input.close();
    }

    public static long merge_sort(int[] q, int left, int right ){

        if (left >= right) return 0;
        int mid = left + right >> 1;
        long res = merge_sort(q, left, mid) + merge_sort(q, mid + 1, right);

        int i = left, j = mid + 1, idx = 0;
        int[] p = new int[right - left + 1];
        while (i <= mid && j <= right)
        {
            if (q[i] <= q[j]){
                p[idx++] = q[i++];
            }
            else {
                res += mid - i + 1;
                p[idx++] = q[j++];
            }
        }
        while (i <= mid) p[idx++] = q[i++];
        while (j <= right) p[idx++] = q[j++];

        for (int k = left, z = 0; k <= right; k++, z++) {
            q[k] = p[z];
        }
        return res;
    }
}

/*
10
88 71 16 2 72 38 94 50 72 67
 */