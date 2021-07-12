package imooc.design.pattern.behavioral.templatemethod;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public abstract class ACourse {
    protected final void makeCourse() {
        this.makePPT();
        this.makeVideo();
        if (this.needWriteArticle()) {
            this.makeArticle();
        }
        this.packageCourse();
    }

    final void makePPT() {
        System.out.println("制作PPT");
    }

    final void makeVideo() {
        System.out.println("制作视频");
    }

    final void makeArticle() {
        System.out.println("编写手记");
    }

    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();
}
