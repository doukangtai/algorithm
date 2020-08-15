package learn.linkedlist;

/**
 * @Author 窦康泰
 * @Date 2020-08-15 8:39
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        Node2 node1 = new Node2(1, "node1");
        Node2 node2 = new Node2(2, "node2");
        Node2 node3 = new Node2(3, "node3");
        Node2 node4 = new Node2(4, "node4");
        Node2 node5 = new Node2(5, "node5");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("添加前");
        doubleLinkedList.show();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node5);
        System.out.println("添加后");
        doubleLinkedList.show();
        Node2 update = new Node2(3, "update");
        doubleLinkedList.update(update);
        System.out.println("更新后");
        doubleLinkedList.show();
        doubleLinkedList.deleteByNo(5);
        System.out.println("删除后");
        doubleLinkedList.show();
        Node2 newNode = new Node2(10, "newNode");
        doubleLinkedList.add(newNode);
        System.out.println("添加newNode节点后");
        doubleLinkedList.show();
    }

}

class DoubleLinkedList {

    private Node2 head = new Node2(0, "");

    public void show() {
        Node2 temp = head;
        if (temp.next == null) {
            System.out.println("链表空，show失败");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void add(Node2 node2) {
        Node2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node2;
        node2.pre = temp;
    }

    /**
     * 如果删除的是最后一个节点，
     * if (temp.next != null) {
     * temp.next.pre = temp.pre;
     * }
     * 判断是否为空，否则会出现空指针异常
     * @param no
     */
    public void deleteByNo(int no) {
        Node2 temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("删除成功");
        }
    }

    public void update(Node2 node2) {
        Node2 temp = head.next;
        if (temp == null) {
            System.out.println("链表空，更新失败");
            return;
        }
        boolean flag = false;
        while (temp != null) {
            if (temp.no == node2.no) {
                temp.data = node2.data;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

}

class Node2 {

    public int no;

    public String data;

    public Node2 pre;

    public Node2 next;

    public Node2(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}
