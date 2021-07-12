package imooc.design.pattern.behavioral.templatemethod;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class DesignPatternCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程Java源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
