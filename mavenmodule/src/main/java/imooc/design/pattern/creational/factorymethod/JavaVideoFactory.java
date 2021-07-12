package imooc.design.pattern.creational.factorymethod;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class JavaVideoFactory extends VideoFactory{
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
