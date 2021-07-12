package imooc.design.pattern.behavioral.visitor;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public interface IVistitor {
    void visit(FreeCourse freeCourse);

    void visit(CodingCourse codingCourse);
}
