package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/02/04
 */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1, new TreeNode(11), null);
        root.right = new TreeNode(11, new TreeNode(1), null);
        System.out.println(new FindDuplicateSubtrees()
                .findDuplicateSubtrees(root));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        help(root);
        return res;
    }

    private Map<String, Integer> memo = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public StringBuilder help(TreeNode root) {
        if (root == null) {
            return new StringBuilder("#");
        }
        StringBuilder sb = new StringBuilder(root.val + "");
        sb.append(",").append(help(root.left)).append(",").append(help(root.right));
        String s = sb.toString();
        Integer count = memo.getOrDefault(s, 0);
        if (count == 1) {
            res.add(root);
        }
        memo.put(s, count + 1);
        return sb;
    }
}
