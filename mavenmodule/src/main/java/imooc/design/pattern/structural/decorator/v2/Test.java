package imooc.design.pattern.structural.decorator.v2;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + " 销售价格：" + aBattercake.cost());
    }
}
