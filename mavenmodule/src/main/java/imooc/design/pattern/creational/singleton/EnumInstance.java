package imooc.design.pattern.creational.singleton;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public enum EnumInstance {
    INSTANCE{
        @Override
        protected void printTest() {
            System.out.println("print test");
        }
    };

    protected abstract void printTest();

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
