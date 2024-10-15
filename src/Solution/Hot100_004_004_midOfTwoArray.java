package Solution;

import static java.lang.Math.max;

public class Hot100_004_004_midOfTwoArray {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int[] all_arr = new int[2010];
        int i = 0, j = 0, cnt = 0;

        int k = (nums1.length + nums2.length) / 2;
//        合并数组
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j]){
                all_arr[cnt] = nums1[i];
                cnt ++;
                i++;
            }else {
                all_arr[cnt] = nums2[j];
                cnt ++;
                j++;
            }
        }
        while (i < nums1.length) {
            all_arr[cnt] = nums1[i];
            cnt ++;
            i ++;
        }
        while (j < nums2.length) {
            all_arr[cnt] = nums2[j];
            cnt ++;
            j ++;
        }
//        选择输出的数
//        for (int l = 0; l < nums1.length + nums2.length; l++) System.out.print(all_arr[l] + " ");
        if ((nums1.length + nums2.length) % 2 == 0){
//            长度为偶数，需要选择两个数取平均，idx为k和k-1的
//            System.out.print("\n" + all_arr[k-1] + " " + all_arr[k] + "\n");
            res = (all_arr[k-1] + all_arr[k]) / 2.0;
        } else {
//            选择最中间的那个即可，取idx为k的
            res = all_arr[k];

        }
        return res;
    }
}
