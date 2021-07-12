package imooc.design.pattern.structural.adapter.objectadapter;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        // ...
        adaptee.adapterRequest();
        // ...
    }
}
