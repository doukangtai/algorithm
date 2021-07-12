package imooc.design.pattern.behavioral.visitor;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class Visitor implements IVistitor {
    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程：" + freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("实战课程：" + codingCourse.getName() + " 价格：" + codingCourse.getPrice() + "元");
    }
}
