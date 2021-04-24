package leetcode.linkedlist.medium;

import leetcode.node.type4.ListNode;

/**
 * @author 窦康泰
 * @date 2021/04/24
 */
public class SwapNodesInPairs {
    static class Method2 {
        public ListNode swapPairs(ListNode head) {
            ListNode res = new ListNode(-1);
            res.next = head;
            ListNode pre = res;
            while (pre.next != null && pre.next.next != null) {
                ListNode p1 = pre.next;
                ListNode p2 = pre.next.next;
                ListNode tail = p2.next;
                p1.next = tail;
                p2.next = p1;
                pre.next = p2;
                pre = p1;
            }
            return res.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(new SwapNodesInPairs().swapPairs(node));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode p1 = head;
        ListNode res = head;
        if (head != null && head.next != null) {
            res = head.next;
        }
        while (p1 != null && p1.next != null) {
            ListNode p2 = p1.next;
            ListNode tail = p2.next;
            if (pre == null) {
                p2.next = p1;
                p1.next = tail;
                pre = p1;
                p1 = tail;
            } else {
                pre.next = p2;
                p2.next = p1;
                p1.next = tail;
                pre = p1;
                p1 = tail;
            }
        }
        return res;
    }
}
