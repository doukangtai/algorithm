package test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class<Test> aClass = Test.class;
        Method method = aClass.getMethod("test", String.class, Integer.class);
        MyAnno annotation = method.getAnnotation(MyAnno.class);
        int age = annotation.age();
        String name = annotation.name();
        double value = annotation.value();
        Test test = aClass.newInstance();
        method.invoke(test, name, age);
        System.out.println(age + "====" + name + "===" + value);
    }

    @MyAnno(name = "dkt233", age = 233)
    public void test(String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnno {
    String name() default "dkt";

    int age() default 18;

    double value() default 1.1;
}
