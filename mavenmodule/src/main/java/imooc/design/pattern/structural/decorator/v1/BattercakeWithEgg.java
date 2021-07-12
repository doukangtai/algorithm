package imooc.design.pattern.structural.decorator.v1;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class BattercakeWithEgg extends Battercake {
    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
