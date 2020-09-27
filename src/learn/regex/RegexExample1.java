package learn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 窦康泰
 * @date 2020/09/26
 */
public class RegexExample1 {

    public static void main(String args[]){
        method2();
    }

    public static void method1() {
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    public static void method2() {
        String content = "I am noob " +
                "from runoob.com." +
                "123abc456";

        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0)); 
        }
    }

}
