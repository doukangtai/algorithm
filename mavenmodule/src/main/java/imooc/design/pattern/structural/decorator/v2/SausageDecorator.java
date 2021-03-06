package imooc.design.pattern.structural.decorator.v2;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABattercake battercake) {
        super(battercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
