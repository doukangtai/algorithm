package imooc.design.pattern.creational.simplefactory;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        video.produce();
    }
}
