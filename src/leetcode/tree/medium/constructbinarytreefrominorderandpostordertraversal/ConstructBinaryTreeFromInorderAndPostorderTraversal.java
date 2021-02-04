package leetcode.tree.medium.constructbinarytreefrominorderandpostordertraversal;

/**
 * @author 窦康泰
 * @date 2021/02/04
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inLeft;
        root.left = build(inorder, inLeft, index - 1, postorder, postLeft, postLeft + leftSize - 1);
        root.right = build(inorder, index + 1, inRight, postorder, postLeft + leftSize, postRight - 1);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
