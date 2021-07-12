package imooc.design.pattern.behavioral.visitor;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public abstract class Course {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(IVistitor vistitor);
}
