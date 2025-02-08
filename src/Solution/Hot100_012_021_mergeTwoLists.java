package Solution;

import javax.print.DocFlavor;

public class Hot100_012_021_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null){
            return a != null ? a : b;
        }

        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode aPt = a, bPt = b;
        while (aPt != null && bPt != null){
            if (aPt.val < bPt.val){
                cur.next = aPt;
                aPt = aPt.next;
            }else {
                cur.next = bPt;
                bPt = bPt.next;
            }
            cur = cur.next;
        }
        if (aPt != null || bPt != null){
            cur.next = aPt != null ? aPt : bPt;
        }

        return head.next;
    }

}


