package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/13
 */
public class BinaryTreeInorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
