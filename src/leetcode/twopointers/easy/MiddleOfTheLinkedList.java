package leetcode.twopointers.easy;

import leetcode.node.type5.ListNode;

/**
 * @author 窦康泰
 * @date 2021/02/16
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
