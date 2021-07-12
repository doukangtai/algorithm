package imooc.design.pattern.behavioral.templatemethod;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Java设计模式课程start");
        ACourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();
        System.out.println("Java设计模式课程end");
        System.out.println("前端设计模式课程start");
        ACourse feCourse = new FECourse(true);
        feCourse.makeCourse();
        System.out.println("前端设计模式课程end");
    }
}
