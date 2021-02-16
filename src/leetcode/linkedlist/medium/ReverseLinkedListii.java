package leetcode.linkedlist.medium;

import leetcode.node.type4.ListNode;

/**
 * @author 窦康泰
 * @date 2021/02/01
 */
public class ReverseLinkedListii {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node2 = root.next = new ListNode(2);
        node2.next = new ListNode(3);
        System.out.println(root);
        System.out.println(new ReverseLinkedListii().reverseBetween(root, 2, 3));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode succNext;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            succNext = head.next;
            return head;
        }
        ListNode lase = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = succNext;
        return lase;
    }
}
