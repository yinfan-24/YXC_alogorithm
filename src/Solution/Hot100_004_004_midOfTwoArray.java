package Solution;

import static java.lang.Math.max;

public class Hot100_004_004_midOfTwoArray {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        boolean is_sigle = false;
        if ((len1 + len2) % 2 == 1){
            is_sigle = true;
        }
        int target = (len1 + len2) / 2;

        int[] all_arr = new int[2010];
        int idx = 0;
        int i = 0, j = 0;
        while (i < len1 && j < len2){
            if (idx == target) break;
            if (nums1[i] < nums2[j]) {
                all_arr[idx] = nums1[i];
                idx++;
                i ++;
            } else {
                all_arr[idx] = nums2[j];
                idx++;
                j ++;
            }
        }
        while (i < len1) {
            if (idx == target) break;
            all_arr[idx] = nums1[i];
            idx++;
            i ++;
        }
        while (j < len2) {
            if (idx == target) break;
            all_arr[idx] = nums2[j];
            idx++;
            j ++;
        }
        if (is_sigle) return  all_arr[target];
        else return (all_arr[target - 1] + all_arr[target]) / 2;
    }
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double res = 0;
//        int[] all_arr = new int[2010];
//        int i = 0, j = 0, cnt = 0;
//
//        int k = (nums1.length + nums2.length) / 2;
////        合并数组
//        while (i < nums1.length && j < nums2.length){
//            if (nums1[i] <= nums2[j]){
//                all_arr[cnt] = nums1[i];
//                cnt ++;
//                i++;
//            }else {
//                all_arr[cnt] = nums2[j];
//                cnt ++;
//                j++;
//            }
//        }
//        while (i < nums1.length) {
//            all_arr[cnt] = nums1[i];
//            cnt ++;
//            i ++;
//        }
//        while (j < nums2.length) {
//            all_arr[cnt] = nums2[j];
//            cnt ++;
//            j ++;
//        }
////        选择输出的数
////        for (int l = 0; l < nums1.length + nums2.length; l++) System.out.print(all_arr[l] + " ");
//        if ((nums1.length + nums2.length) % 2 == 0){
////            长度为偶数，需要选择两个数取平均，idx为k和k-1的
////            System.out.print("\n" + all_arr[k-1] + " " + all_arr[k] + "\n");
//            res = (all_arr[k-1] + all_arr[k]) / 2.0;
//        } else {
////            选择最中间的那个即可，取idx为k的
//            res = all_arr[k];
//
//        }
//        return res;
//    }


}
