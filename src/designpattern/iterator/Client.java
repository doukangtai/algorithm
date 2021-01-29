package designpattern.iterator;

/**
 * @author 窦康泰
 * @date 2021/01/29
 */
public class Client {
    public static void main(String[] args) {
        MyList myList = new MyList();
        Iterator<Integer> iterator = myList.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class MyList {
    private Integer[] items;

    public MyList() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
    }

    public Iterator<Integer> getIterator() {
        return new ConcreteIterator(items);
    }
}

class ConcreteIterator implements Iterator<Integer> {
    private Integer[] items;
    private Integer size = 0;

    public ConcreteIterator(Integer[] items) {
        this.items = items;
    }

    @Override
    public Integer next() {
        return items[size++];
    }

    @Override
    public boolean hasNext() {
        return size < items.length;
    }
}

interface Iterator<T> {
    T next();

    boolean hasNext();
}
