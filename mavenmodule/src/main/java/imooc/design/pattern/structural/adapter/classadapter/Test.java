package imooc.design.pattern.structural.adapter.classadapter;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
