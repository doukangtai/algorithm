package imooc.design.pattern.creational.abstractfactory;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class PythonArticle extends Article{
    @Override
    public void produce() {
        System.out.println("Python手记");
    }
}
