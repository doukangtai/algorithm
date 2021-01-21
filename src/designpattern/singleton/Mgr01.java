package designpattern.singleton;

/**
 * @author 窦康泰
 * @date 2021/01/21
 * 饿汉式
 * 类加载到内存后，实例化一个单例，JVM保证线程安全
 * 简单实用，推荐
 * 唯一缺点，不管是否用到，类加载时都会实例化
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
