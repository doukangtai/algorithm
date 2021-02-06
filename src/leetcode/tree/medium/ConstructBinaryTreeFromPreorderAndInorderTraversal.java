package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/02/04
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int val = preorder[preLeft];
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int leftSize = index - inLeft;
        root.left = build(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, index - 1);
        root.right = build(preorder, preLeft + leftSize + 1, preRight, inorder, index + 1, inRight);
        return root;
    }
}
