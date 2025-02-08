package Solution;

public class Hot100_010_019_removeNthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (--n > 0){
            fast = fast.next;
        }
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (fast == head) return null;
        if (slow == head) return slow.next;
        if (prev != null) prev.next = slow.next;
        return head;
    }
}

