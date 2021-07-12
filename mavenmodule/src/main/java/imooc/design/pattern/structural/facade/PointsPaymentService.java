package imooc.design.pattern.structural.facade;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        System.out.println("支付" + pointsGift.getName() + "积分成功");
        return true;
    }
}
