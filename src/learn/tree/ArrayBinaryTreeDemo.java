package learn.tree;

/**
 * @author 窦康泰
 * @date 2020/10/02
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 8, -2, -6};
//        ArrayBinaryTree.preOrder(array, 0);
//        ArrayBinaryTree.infixOrder(array, 0);
        ArrayBinaryTree.postOrder(array, 0);
    }

}

class ArrayBinaryTree {

    /**
     * 将数组按照前序遍历
     * node的左子树leftIndex = index * 2 + 1
     * node的右子树rightIndex= right * 2 + 2
     * @param array
     * @param index
     */
    public static void preOrder(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.println(array[index]);
        int left = index * 2 + 1;
        preOrder(array, left);
        int right = index * 2 + 2;
        preOrder(array, right);
    }

    public static void infixOrder(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        int left = index * 2 + 1;
        infixOrder(array, left);
        System.out.println(array[index]);
        int right = index * 2 + 2;
        infixOrder(array, right);
    }

    public static void postOrder(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        int left = index * 2 + 1;
        postOrder(array, left);
        int right = index * 2 + 2;
        postOrder(array, right);
        System.out.println(array[index]);
    }

}
