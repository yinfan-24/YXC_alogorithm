package Solution;

import java.util.PriorityQueue;

public class Hot100_014_023_mergeKLists {
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
//    o1.val-o2.val, 如果结果是负数，o1 被认为是小于 o2 的，因此 o1 会排在 o2 之前（即 o1 的优先级更高）

    public ListNode mergeKLists(ListNode[] lists) {
//        先将所有的头节点加入队列
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        ListNode head = new ListNode();
        ListNode node = head;
        while (!priorityQueue.isEmpty()) {
//            弹出队列中最小的元素，将其设置为node.next
            node.next = priorityQueue.poll();
            node = node.next;
//            将刚刚加入的节点的下一个加入队列。
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }
        return head.next;
    }
}
