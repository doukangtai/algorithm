package imooc.design.pattern.creational.abstractfactory;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        video.produce();
        Article article = courseFactory.getArticle();
        article.produce();
    }
}
