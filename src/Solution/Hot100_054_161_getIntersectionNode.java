package Solution;

public class Hot100_054_161_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != null && curB != null){
            curA = curA.next;
            curB = curB.next;
        }

        while (curA != null){
            curA = curA.next;
            headA = headA.next;
        }
        while (curB != null){
            curB = curB.next;
            headB = headB.next;
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
