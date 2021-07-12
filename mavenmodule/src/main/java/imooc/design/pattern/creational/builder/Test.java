package imooc.design.pattern.creational.builder;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("javaName",
                "javaPPT",
                "javaVideo",
                "javaArticle",
                "javaQA");
        System.out.println(course);
    }
}
