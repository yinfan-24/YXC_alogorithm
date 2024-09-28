package Chapter_1;
import java.util.*;
public class ACW_013_797_Diff_algorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n+2];
        int[] dif = new int[n+2];
        for (int i = 1; i < n+1 ; i++) {
            arr[i] = input.nextInt();
            dif[i] = arr[i] - arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            int c = input.nextInt();
            dif[r+1] -= c;
            dif[l] += c;
        }
        for (int i = 1; i < n+1; i++) {
            arr[i] = arr[i-1] + dif[i];
            System.out.print(arr[i]+" ");
        }
    }

}

/*
6 3
1 2 2 1 2 1
1 3 1
3 5 1
1 6 1
 */