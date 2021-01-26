package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/26
 */
public class Client {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        Leaf node1 = new Leaf("1");
        Composite node2 = new Composite("2");
        Leaf node3 = new Leaf("3");
        root.add(node1);
        root.add(node2);
        root.add(node3);
        Composite node21 = new Composite("21");
        Leaf node22 = new Leaf("22");
        node2.add(node21);
        node2.add(node22);
        Leaf node211 = new Leaf("211");
        node21.add(node211);
        root.print();
    }
}

class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(this.name);
    }

    @Override
    void add(Component component) {
        throw new RuntimeException("叶子结点不能add");
    }

    @Override
    void remove(Component component) {
        throw new RuntimeException("叶子结点不能remove");
    }
}

class Composite extends Component {
    private List<Component> componentList;

    public Composite(String name) {
        super(name);
        componentList = new ArrayList<>();
    }

    @Override
    void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(this.name);
        for (Component component : componentList) {
            component.print(level + 1);
        }
    }

    @Override
    void add(Component component) {
        componentList.add(component);
    }

    @Override
    void remove(Component component) {
        componentList.remove(component);
    }
}

abstract class Component {
    public String name;

    public Component(String name) {
        this.name = name;
    }

    public void print() {
        print(0);
    }

    abstract void print(int level);

    abstract void add(Component component);

    abstract void remove(Component component);
}
