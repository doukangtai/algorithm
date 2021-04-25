package leetcode.linkedlist.medium;

import leetcode.node.type4.ListNode;

/**
 * @author 窦康泰
 * @date 2021/04/25
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-1);
        ListNode th1 = h1;
        ListNode th2 = h2;
        ListNode node = head;
        int count = 0;
        while (node != null) {
            if ((count & 1) == 0) {
                th1.next = node;
                th1 = th1.next;
            } else {
                th2.next = node;
                th2 = th2.next;
            }
            node = node.next;
            count++;
        }
        th2.next = null;
        th1.next = h2.next;
        return h1.next;
    }
}
