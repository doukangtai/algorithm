package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;
import leetcode.node.type4.ListNode;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode root = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(root));
    }

    public TreeNode sortedListToBST(ListNode head) {
        return help(head, 1, getLen(head));
    }

    private TreeNode help(ListNode head, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        ListNode temp = head;
        for (int i = 1; i < mid; i++) {
            temp = temp.next;
        }
        TreeNode root = new TreeNode(temp.val);
        root.left = help(head, low, mid - 1);
        root.right = help(head, mid + 1, high);
        return root;
    }

    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
