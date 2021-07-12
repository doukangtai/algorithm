package imooc.design.pattern.structural.adapter.classadapter;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        // ...
        super.adapterRequest();
        // ...
    }
}
