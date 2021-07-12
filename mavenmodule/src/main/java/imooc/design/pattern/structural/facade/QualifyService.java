package imooc.design.pattern.structural.facade;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getName() + "通过");
        return true;
    }
}
