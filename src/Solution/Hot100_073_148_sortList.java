package Solution;


import sun.plugin2.gluegen.runtime.StructAccessor;

import java.net.Inet4Address;

public class Hot100_073_148_sortList {
    public ListNode sortList(ListNode head) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        ListNode cur = head;
        while (cur != null){
            max = Math.max(cur.val, max);
            min = Math.min(cur.val, min);
            cur = cur.next;
        }

        int[] arr = new int[max-min+1];
        cur = head;
        while (cur != null){
            arr[cur.val - min]++;
            cur = cur.next;
        }

        cur = head;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0){
                cur.val = i+min;
                arr[i]--;
                cur = cur.next;
            }
        }
        return head;
    }

//    private ListNode sortList(ListNode head, ListNode trail) {
//        if (head == trail) return null; // 修复1：处理空区间
//        if (head.next == trail) {
//            head.next = null; // 断开链表
//            return head;
//        }
//
//        ListNode fast = head, slow = head;
//        while (fast != trail && fast.next != trail) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        ListNode left = sortList(head, slow); // 左区间 [head, slow)
//        ListNode right = sortList(slow, trail); // 右区间 [slow, trail)
//        return mergeList(left, right);
//    }
//
//    private ListNode mergeList(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode();
//        ListNode curr = dummy;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//            curr = curr.next;
//        }
//        curr.next = (l1 != null) ? l1 : l2;
//        return dummy.next;
//    }
}
