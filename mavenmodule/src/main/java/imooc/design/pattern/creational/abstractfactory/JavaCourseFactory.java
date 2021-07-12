package imooc.design.pattern.creational.abstractfactory;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class JavaCourseFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
