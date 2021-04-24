package leetcode.linkedlist.medium;

import leetcode.node.type4.ListNode;

import java.util.LinkedList;

/**
 * @author 窦康泰
 * @date 2021/04/24
 */
public class AddTwoNumbersIi {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        System.out.println(new AddTwoNumbersIi().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> s1 = new LinkedList<>();
        LinkedList<ListNode> s2 = new LinkedList<>();
        process(s1, l1);
        process(s2, l2);
        ListNode head = new ListNode(-1);
        int num = 0;
        while (num > 0 || !s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop().val;
            int n2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = n1 + n2 + num;
            ListNode node = new ListNode(sum % 10);
            num = sum / 10;
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    private void process(LinkedList<ListNode> s, ListNode l) {
        while (l != null) {
            s.push(l);
            l = l.next;
        }
    }
}
