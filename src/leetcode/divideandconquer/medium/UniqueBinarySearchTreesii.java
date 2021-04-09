package leetcode.divideandconquer.medium;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/09
 */
public class UniqueBinarySearchTreesii {
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesii().generateTrees(0).size());
    }

    public List<TreeNode> generateTrees(int n) {
        return help(1, n);
    }

    private List<TreeNode> help(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = help(s, i - 1);
            List<TreeNode> right = help(i + 1, e);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
