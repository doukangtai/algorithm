package imooc.design.pattern.structural.decorator.v2;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
