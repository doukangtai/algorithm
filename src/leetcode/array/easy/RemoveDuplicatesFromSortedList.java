package leetcode.array.easy;

import leetcode.node.type4.ListNode;

/**
 * @author 窦康泰
 * @date 2021/02/20
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (slow != null) {
            slow.next = null;
        }
        return head;
    }
}
