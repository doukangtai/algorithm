package leetcode.linkedlist.easy;

/**
 * @author 窦康泰
 * @date 2021/02/03
 */
public class PalindromeLinkedList {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return recursion(head);
    }

    public boolean recursion(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = recursion(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }
}

class PalindromeLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(0));
        System.out.println(new PalindromeLinkedList2().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            low = low.next;
        }
        ListNode right = reverse(low);
        while (right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
