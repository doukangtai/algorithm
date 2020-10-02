package learn.tree.threadedbinarytree;

/**
 * @author 窦康泰
 * @date 2020/10/02
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        Node root = getRoot();
        ThreadedBinaryTree.infixOrderThreadedBinaryTree(root);
//        System.out.println(root.left.right);
//        System.out.println(root.left.right.left);
//        System.out.println(root.left.right.right);
        ThreadedBinaryTree.showInfixOrderThreadedBinaryTree(root);

//        ThreadedBinaryTree.preOrderThreadedBinaryTree(root);
//        System.out.println(root.left.left);
//        System.out.println(root.left.left.left);
//        System.out.println(root.left.left.right);
//        System.out.println(root.left.right);
//        System.out.println(root.left.right.left);
//        System.out.println(root.left.right.right);
//        System.out.println(root.right.right);
//        System.out.println(root.right.left.left);
//        System.out.println(root.right.left.right);
//        ThreadedBinaryTree.showPreOrderThreadedBinaryTree(root);

//        Node2 root2 = getRoot2();
//        ThreadedBinaryTree2.postOrderThreadedBinaryTree(root2);
//        System.out.println(root2.left.left);
//        System.out.println(root2.left.left.left);
//        System.out.println(root2.left.left.right);
//        System.out.println(root2.left.right);
//        System.out.println(root2.left.right.left);
//        System.out.println(root2.left.right.right);
//        System.out.println(root2.right.right);
//        System.out.println(root2.right.left.left);
//        System.out.println(root2.right.left.right);
//        ThreadedBinaryTree2.showPostOrderThreadedBinaryTree(root2);
    }

    public static Node getRoot() {
        Node root = new Node(1, "a");
        Node b = new Node(3, "b");
        Node c = new Node(6, "c");
        Node d = new Node(8, "d");
        Node e = new Node(10, "e");
        Node f = new Node(14, "f");
//        root.left = b;
//        root.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        return root;

        // 右单支
        root.right = b;
        b.right = c;
        c.right = d;
        d.right = e;
        e.right = f;
        return root;

        // 左单支
//        root.left = b;
//        b.left = c;
//        c.left = d;
//        d.left = e;
//        e.left = f;
//        return root;
    }

    public static Node2 getRoot2() {
        Node2 root = new Node2(1, "a");
        Node2 b = new Node2(3, "b");
        Node2 c = new Node2(6, "c");
        Node2 d = new Node2(8, "d");
        Node2 e = new Node2(10, "e");
        Node2 f = new Node2(14, "f");
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        b.parent = root;
        c.parent = root;
        d.parent = b;
        e.parent = b;
        f.parent = c;
        return root;

        // 右单只
//        root.right = b;
//        b.right = c;
//        b.parent = root;
//        c.parent = b;
//        return root;

        // 左单只
//        root.left = b;
//        b.left = c;
//        b.parent = root;
//        c.parent = b;
//        return root;
    }

}

class ThreadedBinaryTree {

    /**
     * 前驱节点
     */
    public static Node pre = null;

    /**
     * 前序线索化二叉树时，判断是否到达最左边，防止出现pre指向最左边的父节点
     */
    public static boolean flag = false;

    /**
     * 中序线索化二叉树
     * 思路：
     * pre：为当前节点的前一个节点
     * root：为当前节点
     * 在pre.right和root.left为空的条件下，
     * 将pre.right = root;和root.left = pre;互相指向对方，实现线索化，
     * 注意：pre = root;将pre随时跟在root的后面
     *
     * @param root
     */
    public static void infixOrderThreadedBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        infixOrderThreadedBinaryTree(root.left);
        if (root.left == null) {
            root.leftType = 1;
            root.left = pre;
        }
        if (pre != null && pre.right == null) {
            pre.rightType = 1;
            pre.right = root;
        }
        pre = root;
        infixOrderThreadedBinaryTree(root.right);
    }

    /**
     * 非递归遍历中序线索二叉树
     * 通过循环条件node.leftType == 0找到第一个节点，输出当前节点，
     * 再向右看是不是线索（node.rightType == 1），
     * 若是线索，则根据线索right指针遍历，
     * 否则，将node指向right，继续重复最初的遍历，直到最后一个节点时，while (node == null)退出
     *
     * @param root
     */
    public static void showInfixOrderThreadedBinaryTree(Node root) {
        while (root != null) {
            while (root.leftType == 0) {
                root = root.left;
            }
            System.out.println(root);
            while (root.rightType == 1) {
                root = root.right;
                System.out.println(root);
            }
            root = root.right;
        }
    }

    /**
     * 前序线索二叉树
     * 注意：
     * 通过flag判断是否到达了最左边，防止出现最左边node指向父节点，
     * if (root.leftType != 1)与if (root.rightType != 1)，
     * 用于判断当前节点是否已经线索化，
     * 若没有线索化才递归调用进行线索化
     * @param root
     */
    public static void preOrderThreadedBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            root.leftType = 1;
            root.left = pre;
            flag = true;
        }
        if (pre != null && pre.right == null) {
            pre.rightType = 1;
            pre.right = root;
        }
        if (flag) {
            pre = root;
        }
        if (root.leftType != 1) {
            preOrderThreadedBinaryTree(root.left);
        }
        if (root.rightType != 1) {
            preOrderThreadedBinaryTree(root.right);
        }
    }

    /**
     * 非递归遍历前序线索二叉树
     *
     * @param root
     */
    public static void showPreOrderThreadedBinaryTree(Node root) {
        while (root != null) {
            while (root.leftType == 0) {
                System.out.println(root);
                root = root.left;
            }
            System.out.println(root);
            while (root.rightType == 1) {
                root = root.right;
                System.out.println(root);
            }
            root = root.right;
        }
    }
}

class ThreadedBinaryTree2 {

    public static Node2 pre = null;

    /**
     * 后序线索二叉树
     * @param root
     */
    public static void postOrderThreadedBinaryTree(Node2 root) {
        if (root == null) {
            return;
        }
        postOrderThreadedBinaryTree(root.left);
        postOrderThreadedBinaryTree(root.right);
        if (root.left == null) {
            root.leftType = 1;
            root.left = pre;
        }
        if (pre != null && pre.right == null) {
            pre.rightType = 1;
            pre.right = root;
        }
        pre = root;
    }

    /**
     * 非递归遍历后序线索二叉树
     * 思路：先找到最左边的节点，
     * 判断当前这个最左边的节点是否是线索节点，
     * 若是线索节点，则通过线索遍历输出，直到遇到node.rightType == 0，
     * 再判断是否是根节点，
     * 若是根节点：
     * 若node == root && node.right == preNode，则表明正常遍历到root节点，输出root，退出即可，
     * 若node == root && node.right == null，则表明左单只，输出root，退出即可，
     * 若不是根节点：
     * 若node != null && node.right == preNode，则表明node子树遍历完，再寻找parent节点，
     * 若node != null && node.right == preNode不成立，则去parent节点的右节点遍历，
     * 循环遍历，直到结束。
     * @param root
     */
    public static void showPostOrderThreadedBinaryTree(Node2 root) {
        Node2 node = root;
        Node2 preNode = null;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            while (node.rightType == 1) {
                System.out.println(node);
                preNode = node;
                node = node.right;
            }
            if (node == root && node.right == preNode) {
                System.out.println(node);
                return;
            }
            if (node == root && node.right == null) {
                System.out.println(node);
                return;
            }
            while (node != null && node.right == preNode) {
                System.out.println(node);
                preNode = node;
                node = node.parent;
            }
            if (node != null && node.rightType == 0) {
                node = node.right;
            }
        }
    }
}

class Node {
    public int id;
    public String name;
    public Node left;
    public Node right;
    /**
     * 0表示指向左子树，1表示指向前驱节点
     */
    public int leftType;
    /**
     * 0表示指向右子树，1表示指向后继节点
     */
    public int rightType;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Node2 {
    public int id;
    public String name;
    public Node2 left;
    public Node2 right;
    public Node2 parent;
    /**
     * 0表示指向左子树，1表示指向前驱节点
     */
    public int leftType;
    /**
     * 0表示指向右子树，1表示指向后继节点
     */
    public int rightType;

    public Node2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
