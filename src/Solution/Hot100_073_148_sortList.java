package Solution;


import sun.plugin2.gluegen.runtime.StructAccessor;

public class Hot100_073_148_sortList {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null) return head;
        if (head.next == tail){
            head.next = null;
            return head;
        }
//        切分
        ListNode slow = head, fast = head;
        while (fast != tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != tail){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = mergeList(list1, list2);
        return sorted;
    }

    public ListNode mergeList(ListNode node1, ListNode node2){
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead, tmp1 = node1, tmp2 = node2;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val <= tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if (tmp1 != null){
            tmp.next = tmp1;
        }else if (tmp2 != null){
            tmp.next = tmp2;
        }
        return newHead.next;
    }

}
