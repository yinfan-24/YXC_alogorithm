package Solution;


import java.util.HashSet;
import java.util.Set;

public class Hot100_074_142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode pre = head, slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else return null;
            if (fast == slow){
                while (pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
