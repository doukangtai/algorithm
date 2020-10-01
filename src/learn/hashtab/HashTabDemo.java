package learn.hashtab;

/**
 * 思路：哈希表 = 数组 + 链表
 * 通过hashFunction采用简单取模方法获取哈希值，
 * 确定emp在数组的哪个位置，
 * 再将emp放在对应位置链表最后
 * @author 窦康泰
 * @date 2020/10/01
 */
public class HashTabDemo {

    public static void main(String[] args) {
        Emp a = new Emp(1, "aaa");
        Emp b = new Emp(2, "bbb");
        Emp c = new Emp(3, "ccc");
        Emp d = new Emp(4, "ddd");
        Emp e = new Emp(5, "eee");
        HashTab hashTab = new HashTab(3);
        hashTab.add(a);
        hashTab.add(b);
        hashTab.add(c);
        hashTab.add(d);
        hashTab.add(e);
        hashTab.list();
    }

}

class HashTab {
    public int size;
    public EmpHeadLinkedList[] empHeadLinkedListArray;

    public HashTab(int size) {
        this.size = size;
        empHeadLinkedListArray = new EmpHeadLinkedList[size];
        for (int i = 0; i < size; i++) {
            empHeadLinkedListArray[i] = new EmpHeadLinkedList();
        }
    }

    public void add(Emp emp) {
        empHeadLinkedListArray[hashFunction(emp.id)].add(emp);
    }

    public void list() {
        for (int i = 0; i < empHeadLinkedListArray.length; i++) {
            empHeadLinkedListArray[i].list();
        }
    }

    public int hashFunction(int id) {
        return id % size;
    }
}

class EmpHeadLinkedList {
    public Emp head;

    public EmpHeadLinkedList() {
        head = new Emp();
    }

    public void add(Emp emp) {
        if (head.next == null) {
            head.next = emp;
            return;
        }
        Emp currEmp = head.next;
        while (currEmp.next != null) {
            currEmp = currEmp.next;
        }
        currEmp.next = emp;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("当前链表为空");
            return;
        }
        Emp currEmp = head.next;
        while (currEmp != null) {
            System.out.print(currEmp + " ===> ");
            currEmp = currEmp.next;
        }
        System.out.println();
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp() {
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
