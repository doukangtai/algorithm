package leetcode.linkedlist.medium;

import leetcode.node.type5.ListNode;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/25
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        root.next = n2;
        n2.next = n3;
        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(root, 5)));
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode node = root;
        while (node != null) {
            len++;
            node = node.next;
        }
        int div = len / k;
        int mod = len % k;
        for (int i = 0; i < k && root != null; i++) {
            res[i] = root;
            int temp = mod > i ? div + 1 : div;
            for (int j = 0; j < temp - 1; j++) {
                root = root.next;
            }
            ListNode next = root.next;
            root.next = null;
            root = next;
        }
        return res;
    }
}
