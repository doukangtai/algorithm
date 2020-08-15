package learn.linkedlist;

/**
 * @Author 窦康泰
 * @Date 2020-08-15 13:32
 */
public class JosephDemo {

    public static void main(String[] args) {
        JosephCircleLinkedList josephCircleLinkedList = new JosephCircleLinkedList();
        josephCircleLinkedList.create(10);
        System.out.println("原始链表");
        josephCircleLinkedList.show();
        System.out.println("约瑟夫问题");
        josephCircleLinkedList.joseph(1, 10);
    }

}

class JosephCircleLinkedList {

    private Node3 first = null;

    public void create(int size) {
        Node3 curr = null;
        for (int i = 1; i <= size; i++) {
            Node3 node = new Node3(i, "node" + i);
            if (first == null) {
                first = node;
                first.next = first;
                curr = first;
            } else {
                curr.next = node;
                node.next = first;
                curr = node;
            }
        }
    }

    /**
     * 当curr.next == first时，表示到链表最后一个
     */
    public void show() {
        if (first == null) {
            System.out.println("链表空");
            return;
        }
        Node3 curr = first;
        while (curr.next != first) {
            System.out.println(curr);
            curr = curr.next;
        }
        System.out.println(curr);
    }

    /**
     * 1. 遍历一遍获取first的前一个节点pre
     * 2. first和pre同时移动，将first移动到startNo
     * 3. 每次移动count-1次，输出first，直到剩下最后一个时，直接输出最后一个
     * @param startNo 从第几号开始数
     * @param count 数多少个
     */
    public void joseph(int startNo, int count) {
        int length = getLength();
        if (startNo < 1 || startNo > length || first == null) {
            System.out.println("链表空或输入的数据越界");
            return;
        }
        Node3 pre = first;
        while (pre.next != first) {
            pre = pre.next;
        }
        while (startNo != first.no) {
            first = first.next;
            pre = pre.next;
        }
        while (first.next != first) {
            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                pre = pre.next;
            }
            System.out.println(first);
            first = first.next;
            pre.next = first;
        }
        System.out.println(first);
    }

    public int getLength() {
        Node3 curr = first;
        int count = 0;
        while (curr.next != first) {
            count++;
            curr = curr.next;
        }
        return ++count;
    }

}

class Node3 {

    public int no;

    public String data;

    public Node3 next;

    public Node3(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node3{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}
