package imooc.design.pattern.creational.builder.v2;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("javaName").buildCoursePPT("javaPPT").buildCourseVideo("javaVideo").buildCourseArticle("javaArticle").buildCourseQA("javaQA").build();
        System.out.println(course);
    }
}
