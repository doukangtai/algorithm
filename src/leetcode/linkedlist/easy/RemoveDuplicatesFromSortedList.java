package leetcode.linkedlist.easy;

import leetcode.node.type4.ListNode;

/**
 * @author 窦康泰
 * @date 2021/04/23
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
