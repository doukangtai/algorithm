package imooc.design.pattern.behavioral.visitor;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class FreeCourse extends Course{
    @Override
    public void accept(IVistitor vistitor) {
        vistitor.visit(this);
    }
}
