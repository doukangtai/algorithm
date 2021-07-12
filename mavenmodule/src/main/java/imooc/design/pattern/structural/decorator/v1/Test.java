package imooc.design.pattern.structural.decorator.v1;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc() + " 价格：" + battercake.cost());
        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc() + " 价格：" + battercakeWithEgg.cost());
        Battercake battercakeWithEggSausage = new BattercakeWithEggSausage();
        System.out.println(battercakeWithEggSausage.getDesc() + " 价格：" + battercakeWithEggSausage.cost());
    }
}
