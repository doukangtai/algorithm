package imooc.design.pattern.structural.adapter.objectadapter;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget目标方法");
    }
}
