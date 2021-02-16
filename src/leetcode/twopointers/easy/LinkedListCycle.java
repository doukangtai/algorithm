package leetcode.twopointers.easy;

import leetcode.node.type5.ListNode;

/**
 * @author 窦康泰
 * @date 2021/02/16
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
