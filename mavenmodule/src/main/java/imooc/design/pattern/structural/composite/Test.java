package imooc.design.pattern.structural.composite;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux课程", 1);
        CatalogComponent windowsCourse = new Course("Windows课程", 2);
        CatalogComponent javaCourseCatalog = new CourseCatalog("java课程目录", 2);
        javaCourseCatalog.add(new Course("java一期", 10));
        javaCourseCatalog.add(new Course("java二期", 20));
        javaCourseCatalog.add(new Course("java三期", 30));
        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("imooc主课程目录", 1);
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);
        imoocMainCourseCatalog.print();
    }
}
