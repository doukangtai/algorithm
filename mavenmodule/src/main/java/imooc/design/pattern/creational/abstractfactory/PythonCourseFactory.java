package imooc.design.pattern.creational.abstractfactory;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class PythonCourseFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
