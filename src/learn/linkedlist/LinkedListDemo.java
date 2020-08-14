package learn.linkedlist;

import java.util.Stack;

/**
 * @Author 窦康泰
 * @Date 2020-08-14 11:08
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1,"data1");
        Node node2 = new Node(2, "data2");
        Node node3 = new Node(3, "data3");
        Node node4 = new Node(4, "data4");
        Node node5 = new Node(5, "data5");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);
//        singleLinkedList.add(node5);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node5);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node2);
//        System.out.println("修改node3前");
//        singleLinkedList.show();
//        Node updateNode1 = new Node(3, "update1");
//        singleLinkedList.updateByNo(updateNode1);
//        System.out.println("修改node3后");
//        singleLinkedList.show();
//        singleLinkedList.deleteByNo(1);
//        singleLinkedList.deleteByNo(3);
//        singleLinkedList.deleteByNo(5);
//        System.out.println("删除node1");
//        singleLinkedList.show();
//        System.out.println("单链表长度");
//        System.out.println(singleLinkedList.getLength());
//        System.out.println(singleLinkedList.findLastIndexNode(1));
//        System.out.println("reverse前");
//        singleLinkedList.show();
//        singleLinkedList.reverseList();
//        System.out.println("reverse后");
//        singleLinkedList.show();
        singleLinkedList.reversePrint();
    }

}

class SingleLinkedList {

    private Node head = new Node(0, "");

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                temp.next = node;
                break;
            }
        }
    }

    public void show() {
        Node temp = head;
        if (temp.next == null) {
            System.out.println("链表空，show失败");
            return;
        }
        while (true) {
            if (temp.next != null) {
                temp = temp.next;
                System.out.println(temp);
            } else {
                break;
            }
        }
    }

    public void addByOrder(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next != null) {
                if (temp.next.no >= node.no) {
                    node.next = temp.next;
                    temp.next = node;
                    break;
                } else {
                    temp = temp.next;
                }
            } else {
                temp.next = node;
                break;
            }
        }
    }

    public void updateByNo(Node node) {
        Node temp = head;
        if (temp.next == null) {
            System.out.println("链表空，update失败");
            return;
        }
        while (true) {
            if (temp.next != null) {
                if (temp.next.no == node.no) {
                    temp.next.data = node.data;
                    break;
                } else {
                    temp = temp.next;
                }
            } else {
                System.out.println("更新失败");
                break;
            }
        }
    }

    public void deleteByNo(int no) {
        Node temp = head;
        if (temp.next == null) {
            System.out.println("链表空，delete失败");
            return;
        }
        while (true) {
            if (temp.next != null) {
                if (temp.next.no == no) {
                    temp.next = temp.next.next;
                    break;
                } else {
                    temp = temp.next;
                }
            } else {
                System.out.println("删除失败");
                break;
            }
        }
    }

    /**
     * 获取单链表长度（不统计头结点）
     * 1. 遍历链表，获取长度length
     * @return
     */
    public int getLength() {
        int length = 0;
        Node temp = head;
        while (true) {
            if (temp.next != null) {
                length++;
                temp = temp.next;
            } else {
                break;
            }
        }
        return length;
    }

    /**
     * 查找倒数第几个节点
     * 1. 遍历获取链表长度length
     * 2. 获取需要遍历的节点个数len，遍历len次
     * 3. 由于temp初始为head，所以temp.next为要查找的节点
     * @param index
     * @return
     */
    public Node findLastIndexNode(int index) {
        int length = getLength();
        int len = length - index;
        if (len < 0 || len >= length) {
            System.out.println("越界了");
            return null;
        }
        Node temp = head;
        while (true) {
            if (temp.next != null) {
                if (len != 0) {
                    temp = temp.next;
                    len--;
                } else {
                    break;
                }
            }
        }
        return temp.next;
    }

    /**
     * 将链表反转
     * 1. 创建临时反转链表头reverseHead，创建next保存主链表下一个地址，防止curr.next = reverseHead.next;后丢失
     * 2. 遍历主链表，将每个节点放在reverseHead.next中，即可得到反转链表reverseHead
     * 3. head.next = reverseHead.next;获取反转链表
     */
    public void reverseList() {
        Node curr = head.next;
        Node reverseHead = new Node(0, "");
        Node next = null;
        while (true) {
            if (curr != null) {
                next = curr.next;
                curr.next = reverseHead.next;
                reverseHead.next = curr;
                curr = next;
            } else {
                break;
            }
        }
        head.next = reverseHead.next;
    }

    /**
     * 方法一：先反转链表reverseList，再遍历；会破坏链表原有结构
     * 方法二：先入栈，再出栈
     * 此处采用栈
     */
    public void reversePrint() {
        Node curr = head.next;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

class Node {

    public int no;

    public String data;

    public Node next;

    public Node(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}
