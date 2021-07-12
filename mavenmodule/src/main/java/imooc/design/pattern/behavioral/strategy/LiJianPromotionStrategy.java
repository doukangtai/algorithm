package imooc.design.pattern.behavioral.strategy;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class LiJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减");
    }
}
