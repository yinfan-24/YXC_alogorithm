package Solution;

import java.util.ArrayList;
import java.util.List;

public class Hot100_056_234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int l = 0, r = n-1;
        while (l < r){
            if (list.get(l) != list.get(r)){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
