package Solution;

import java.util.ArrayList;
import java.util.List;

public class Hot100_056_234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headB = reverseList(slow, fast);
        ListNode headA = head;
        while (headA != null && headB != null){
            if (headA.val != headB.val) return false;
            headA = headA.next;
            headB = headB.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head, ListNode trail){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
