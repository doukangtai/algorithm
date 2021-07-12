package imooc.design.pattern.behavioral.chainofresponsibility;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public abstract class Approver {
    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);
}
