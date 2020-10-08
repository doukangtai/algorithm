package learn.binarysorttree;

/**
 * @author 窦康泰
 * @date 2020/10/07
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 8};
        BinarySortTree.buildBinarySortTree(array);
//        BinarySortTree.delNode(12);
        BinarySortTree.delNode(3);
//        BinarySortTree.delNode(5);
//        BinarySortTree.delNode(7);
//        BinarySortTree.delNode(8);
//        BinarySortTree.delNode(9);
//        BinarySortTree.delNode(1);
//        BinarySortTree.delNode(10);
        BinarySortTree.infixOrder(BinarySortTree.root);
    }

}

/**
 * 二叉排序树
 * 大的值排在右边，小的值排在左边
 */
class BinarySortTree {

    public static Node root;

    /**
     * 删除指定节点，
     * 三种情况：
     * ①：叶子结点
     * ②：单子树节点
     * ③：双子树节点
     * @param value
     */
    public static void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(root, value);
            if (targetNode == null) {
                return;
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                    return;
                } else {
                    if (targetNode.left == null && targetNode.right == null) {
                        // 删除叶子结点
                        Node parentNode = searchParent(root, value);
                        if (parentNode.left != null && parentNode.left.value == value) {
                            parentNode.left = null;
                        } else if (parentNode.right != null && parentNode.right.value == value) {
                            parentNode.right = null;
                        }
                    } else if (targetNode.left != null && targetNode.right != null) {
                        // 删除双分支节点
                        int min = delRightTreeMin(targetNode.right);
                        targetNode.value = min;
                    } else {
                        // 删除单分支节点
                        Node parentNode = searchParent(root, value);
                        if (parentNode != null) {
                            if (parentNode.left != null) {
                                if (targetNode.left != null) {
                                    parentNode.left = targetNode.left;
                                } else {
                                    parentNode.left = targetNode.right;
                                }
                            } else {
                                if (targetNode.left != null) {
                                    parentNode.right = targetNode.left;
                                } else {
                                    parentNode.right = targetNode.right;
                                }
                            }
                        } else {
                            if (targetNode.left != null) {
                                root = targetNode.left;
                            } else {
                                root = targetNode.right;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 删除右子树的最小值节点，并返回最小值
     * @param root
     * @return
     */
    public static int delRightTreeMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        delNode(root.value);
        return root.value;
    }

    /**
     * 查找指定值的节点
     * @param root
     * @param value
     * @return
     */
    public static Node search(Node root, int value) {
        if (root != null) {
            if (root.value == value) {
                return root;
            } else if (root.value < value) {
                return search(root.right, value);
            } else {
                return search(root.left, value);
            }
        } else {
            return null;
        }
    }

    /**
     * 查找指定值的父节点
     * @param root
     * @param value
     * @return
     */
    public static Node searchParent(Node root, int value) {
        if (root != null) {
            if ((root.left != null && root.left.value == value)
                    || (root.right != null && root.right.value == value)) {
                return root;
            } else {
                if (root.left != null && root.value > value) {
                    return searchParent(root.left, value);
                } else if (root.right != null && root.value < value) {
                    return searchParent(root.right, value);
                }
            }
        }
        return null;
    }

    /**
     * 建立二叉排序树
     * @param array
     * @return
     */
    public static Node buildBinarySortTree(int[] array) {
        root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            add(root, array[i]);
        }
        return root;
    }

    /**
     * 借助递归调用将大值添加在右子树，小值添加在左子树
     * @param root
     * @param value
     */
    public static void add(Node root, int value) {
        if (value <= root.value) {
            if (root.left == null) {
                root.left = new Node(value);
            } else {
                add(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(value);
            } else {
                add(root.right, value);
            }
        }
    }

    public static void infixOrder(Node root) {
        if (root == null) {
            return;
        }
        infixOrder(root.left);
        System.out.println(root);
        infixOrder(root.right);
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
