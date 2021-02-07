package leetcode.tree.hard;

import leetcode.node.type3.TreeNode;

import java.util.LinkedList;

/**
 * @author 窦康泰
 * @date 2021/02/07
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        root.left = node21;
        TreeNode node22 = new TreeNode(3);
        root.right = node22;
        TreeNode node33 = new TreeNode(4);
        TreeNode node34 = new TreeNode(5);
        node22.left = node33;
        node22.right = node34;
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        String serialize = serializeAndDeserializeBinaryTree.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = serializeAndDeserializeBinaryTree.deserialize(serialize);
        System.out.println(deserialize);

    }

    private String NULL = "#";
    private String SPE = ",";
    private StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SPE);
            return null;
        }
        sb.append(root.val).append(SPE);
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(SPE)) {
            list.offer(s);
        }
        return help(list);
    }

    public TreeNode help(LinkedList<String> list) {
        if (list.size() <= 0) {
            return null;
        }
        String val = list.pollFirst();
        if (val.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = help(list);
        root.right = help(list);
        return root;
    }
}
