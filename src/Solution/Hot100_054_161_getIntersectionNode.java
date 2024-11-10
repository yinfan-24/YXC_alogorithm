package Solution;

public class Hot100_054_161_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;
        int n = 0, m = 0;
        while (a != null){
            a = a.next;
            n ++;
        }
        while (b != null){
            b = b.next;
            m ++;
        }

        a = headA;
        b = headB;
        int i = 0;
        if (n < m){
            while (i + n < m) {
                i ++;
                b = b.next;
            }
        }else {
            while (i + m < n) {
                i ++;
                a = a.next;
            }

        }
        while (a != null && b != null){
            if (a == b) return a;
            else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}
