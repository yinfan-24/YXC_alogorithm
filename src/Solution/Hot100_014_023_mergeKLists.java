package Solution;

import java.util.PriorityQueue;

public class Hot100_014_023_mergeKLists {
//    定义优先队列的排序方式
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode i: lists) {
            if (i != null) priorityQueue.add(i);
        }

        ListNode head = new ListNode();
        ListNode trail = head;
        while (!priorityQueue.isEmpty()){
            trail.next = priorityQueue.poll();
            trail = trail.next;
            if (trail.next != null) priorityQueue.add(trail.next);
        }

        return head.next;
    }
}
