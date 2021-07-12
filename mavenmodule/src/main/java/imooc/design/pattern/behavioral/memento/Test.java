package imooc.design.pattern.behavioral.memento;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class Test {
    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();
        Article article = new Article("设计模式A", "手记内容A", "手记图片A");
        ArticleMemento articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println("手记完整内容：" + article);
        System.out.println("修改手记start");
        article.setTitle("设计模式B");
        article.setContent("手记内容B");
        article.setImgs("手记图片B");
        System.out.println("修改手记end");
        System.out.println("手记完整信息：" + article);
        articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        article.setTitle("设计模式C");
        article.setContent("手记内容C");
        article.setImgs("手记图片C");
        System.out.println("暂存回退start");
        System.out.println("回退出栈1次");
        articleMemento = articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);
        System.out.println("回退出栈2次");
        articleMemento = articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);
        System.out.println("暂存回退end");
        System.out.println("手记完整信息：" + article);
    }
}
