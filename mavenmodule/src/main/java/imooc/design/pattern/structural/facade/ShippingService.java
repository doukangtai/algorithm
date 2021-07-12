package imooc.design.pattern.structural.facade;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class ShippingService {
    public String shipGift(PointsGift pointsGift) {
        System.out.println(pointsGift.getName() + "进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
