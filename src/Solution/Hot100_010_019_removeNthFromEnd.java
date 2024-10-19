package Solution;

public class Hot100_010_019_removeNthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
//        求倒数第 n 个节点：先让快指针往前移动 n 个，再让慢指针和快指针同时移动，保持固定距离。
        for (int i = 0; i < n-1; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null){
             fast = fast.next;
             prev = slow;
             slow = slow.next;
        }
//        只有一个节点，那移除后必然为空
        if (fast == head) return null;
//        slow根本没有移动：fast已经在末尾了，说明删除的就是头节点
        if (slow == head) return slow.next;
//        正常情况的删除
        if (prev != null) prev.next = slow.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}