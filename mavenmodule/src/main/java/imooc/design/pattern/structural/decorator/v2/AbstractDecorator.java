package imooc.design.pattern.structural.decorator.v2;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class AbstractDecorator extends ABattercake{
    private ABattercake battercake;

    public AbstractDecorator(ABattercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getDesc() {
        return this.battercake.getDesc();
    }

    @Override
    protected int cost() {
        return this.battercake.cost();
    }
}
