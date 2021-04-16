package leetcode.backtracking.easy;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/16
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(root, res, new StringBuilder().append(root.val));
        return res;
    }

    private void help(TreeNode root, List<String> res, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            if (sb.length() == 0) {
                sb.append(root.left.val);
                help(root.left, res, sb);
                sb.delete(sb.length() - String.valueOf(root.left.val).length(), sb.length());
            } else {
                sb.append("->").append(root.left.val);
                help(root.left, res, sb);
                sb.delete(sb.length() - ("->" + root.left.val).length(), sb.length());
            }
        }
        if (root.right != null) {
            if (sb.length() == 0) {
                sb.append(root.right.val);
                help(root.right, res, sb);
                sb.delete(sb.length() - String.valueOf(root.right.val).length(), sb.length());
            } else {
                sb.append("->").append(root.right.val);
                help(root.right, res, sb);
                sb.delete(sb.length() - ("->" + root.right.val).length(), sb.length());
            }
        }
    }
}
