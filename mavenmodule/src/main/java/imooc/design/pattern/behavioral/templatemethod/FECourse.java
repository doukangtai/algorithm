package imooc.design.pattern.behavioral.templatemethod;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class FECourse extends ACourse {
    private boolean isNeedWriteArticle;

    @Override
    void packageCourse() {
        System.out.println("提供课程前端源代码");
        System.out.println("提供课程图片等媒体素材");
    }

    public FECourse(boolean isNeedWriteArticle) {
        this.isNeedWriteArticle = isNeedWriteArticle;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.isNeedWriteArticle;
    }
}
