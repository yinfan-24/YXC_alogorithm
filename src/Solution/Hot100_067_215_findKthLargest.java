package Solution;

public class Hot100_067_215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n-1, n-k);
    }

    int quickselect(int[] nums, int l, int r, int k){
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j){
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
//        j 就是当前已经确定最终位置的元素的下标
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j+1, r, k);
    }
//    public int findKthLargest(int[] nums, int k) {
//        int n = nums.length;
//        buildHeap(nums, n);
//
//        for (int i = nums.length-1; i >= nums.length - k; i--){
//            swap(nums, 0, i);
//            n--;
//            down(nums, 0, n);
//        }
//        return nums[0];
//    }
//
//    public void buildHeap(int[] heap, int heapSize){
//        for (int i = heapSize/2 - 1; i >= 0 ; i--) {
//            down(heap, i, heapSize);
//        }
//    }
//
//    public void down(int[] heap, int i, int heapSize){
//        int l = 2*i + 1, r = 2*i + 2;
//        int large = i;
//        if (l < heapSize && heap[l] > heap[large]){
//            large = l;
//        }
//        if (r < heapSize && heap[r] > heap[large]){
//            large = r;
//        }
//        if (large != i){
//            swap(heap, large, i);
////            上面交换了heap存储的值，需要继续down的索引依然是large
//            down(heap, large, heapSize);
//        }
//    }
//
//    public void swap(int[] heap, int x, int y){
//        int tmp = heap[x];
//        heap[x] = heap[y];
//        heap[y] = tmp;
//    }
}
