package learn.tree;

/**
 * @author 窦康泰
 * @date 2020/10/01
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        Node root = getRootNode();

//        preOrder(root);
//        infixOrder(root);
//        postOrder(root);

//        System.out.println(preOrderSearch(root, 20));
//        System.out.println(infixOrderSearch(root, 30));
//        System.out.println(postOrderSearch(root, 40));

        System.out.println("删除之前");
        preOrder(root);
        int deleteId = 3;
        if (root != null) {
            if (root.id == deleteId) {
                root = null;
            } else {
                deleteNodeById(root, deleteId);
            }
        }
        System.out.println("删除之后");
        preOrder(root);
    }

    public static Node getRootNode() {
        Node root = new Node(1, "a");
        Node b = new Node(2, "b");
        Node c = new Node(3, "c");
        Node d = new Node(4, "d");
        Node e = new Node(5, "e");
        root.left = b;
        root.right = c;
        c.left = d;
        c.right = e;
        return root;
    }

    public static void deleteNodeById(Node root, int id) {
        if (root.left != null && root.left.id == id) {
            root.left = null;
            return;
        }
        if (root.right != null && root.right.id == id) {
            root.right = null;
            return;
        }
        if (root.left != null) {
            deleteNodeById(root.left, id);
        }
        if (root.right != null) {
            deleteNodeById(root.right, id);
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 前序遍历查找
     *
     * @param root
     * @param id
     * @return
     */
    public static Node preOrderSearch(Node root, int id) {
        Node node = null;
        if (root != null) {
//            System.out.println(root);
            if (root.id == id) {
                return root;
            }
            node = preOrderSearch(root.left, id);
            if (node != null) {
                return node;
            }
            node = preOrderSearch(root.right, id);
        }
        return node;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void infixOrder(Node root) {
        if (root != null) {
            infixOrder(root.left);
            System.out.println(root);
            infixOrder(root.right);
        }
    }

    /**
     * 中序遍历查找
     *
     * @param root
     * @param id
     * @return
     */
    public static Node infixOrderSearch(Node root, int id) {
        Node node = null;
        if (root != null) {
            node = infixOrderSearch(root.left, id);
            if (node != null) {
                return node;
            }
//            System.out.println(root);
            if (root.id == id) {
                return root;
            }
            node = infixOrderSearch(root.right, id);
        }
        return node;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root);
        }
    }

    /**
     * 后序遍历查找
     *
     * @param root
     * @param id
     * @return
     */
    public static Node postOrderSearch(Node root, int id) {
        Node node = null;
        if (root != null) {
            node = postOrderSearch(root.left, id);
            if (node != null) {
                return node;
            }
            node = postOrderSearch(root.right, id);
            System.out.println(root);
            if (root.id == id) {
                return root;
            }
        }
        return node;
    }

}

class Node {
    public int id;
    public String name;
    public Node left;
    public Node right;

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
