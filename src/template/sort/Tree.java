package template.sort;

/**
 * @Author 窦康泰
 * @Date 2020-07-17 15:21
 */
public class Tree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static Node buildTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        Node node = new Node(arr[index]);
        node.left = buildTree(arr, index * 2 + 1);
        node.right = buildTree(arr, index * 2 + 2);
        return node;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node root = buildTree(array, 0);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

}
