package imooc.design.pattern.creational.abstractfactory;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class JavaArticle extends Article{
    @Override
    public void produce() {
        System.out.println("JAVA手记");
    }
}
