package learn.avl;

/**
 * @author 窦康泰
 * @date 2020/10/08
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] array = {7, 3, 10, 12, 5, 1, 9};
//        int[] array = {11, 3, 10, 12, 5, 1, 9};
        int[] array = {10, 11, 7, 6, 8, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        Node root = binarySortTree.create(array);
//        binarySortTree.infixOrder(root);
        System.out.println(root.height());
        System.out.println(root.leftHeight());
        System.out.println(root.rightHeight());
        System.out.println(root);
    }

}

/**
 * 为了解决二叉排序树可能会形成单侧链表形式的二叉树，
 * 平衡二叉树：左子树与右子树的高度差不大于一，并且左子树与右子树都是平衡二叉树
 */
class BinarySortTree {
    public Node root;

    /**
     * 创建平衡二叉树
     *
     * @param array
     * @return
     */
    public Node create(int[] array) {
        root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            root.add(new Node(array[i]));
        }
        return root;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void infixOrder(Node root) {
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

    /**
     * 递归调用给平衡二叉树添加节点
     * 每添加一个节点，判断当前节点的左右子树高度差，
     * 1.若左子树高度与右子树高度差大于1，
     * 则判断左子树的右子树高度是否大于左子树的左子树高度，
     * 若成立，则将左子树进行左旋，再对当前节点进行右旋
     * 2.若右子树高度与左子树高度差大于1，
     * 则判断右子树的左子树高度是否大于右子树的右子树，
     * 若成立，则将右子树进行右旋，在对当前节点进行左旋
     *
     * @param node
     */
    public void add(Node node) {
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
                this.leftRotate();
            } else {
                this.leftRotate();
            }
        }
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
                this.rightRotate();
            } else {
                this.rightRotate();
            }
        }
    }

    /**
     * 获取当前节点的树高度，
     * 借助递归每次+1获取树高
     *
     * @return
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    /**
     * 获取左子树高度
     *
     * @return
     */
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        }
        return this.left.height();
    }

    /**
     * 获取右子树高度
     *
     * @return
     */
    public int rightHeight() {
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
    }

    /**
     * 左旋转
     * new一个新节点，将当前节点的值给新节点，
     * 将新节点的左子树指向当前节点的左子树，
     * 将新节点的右子树指向当前节点右子树的左子树，
     * 将当前节点右节点的值给当前节点，
     * 将当前节点左子树指向新节点，
     * 将当前节点右子树指向当前节点右子树的右子树
     */
    public void leftRotate() {
        Node newNode = new Node(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.left = newNode;
        this.value = this.right.value;
        this.right = this.right.right;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "value=" + value +
//                '}';
//    }
}
