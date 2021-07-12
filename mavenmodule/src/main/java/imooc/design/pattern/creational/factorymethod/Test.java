package imooc.design.pattern.creational.factorymethod;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
