package javabasic;

/**
 * @Author 窦康泰
 * @Date 2020-08-10 17:28
 */
public class HashSetTest {

    static class In {
        public static void main(String[] args) {
            HashSetTest hashSetTest = new HashSetTest();
            System.out.println(hashSetTest.privateString);
        }
    }

    public static void main(String[] args) {
        HashSetTest hashSetTest = new HashSetTest();
        String privateString = hashSetTest.privateString;
        System.out.println(privateString);
        String privateString1 = hashSetTest.getPrivateString();
        System.out.println(privateString1);

        DefaultClass defaultClass = new DefaultClass();
        String defaultString = defaultClass.getDefaultString();
        System.out.println(defaultString);
        String defaultString1 = defaultClass.defaultString;
        System.out.println(defaultString1);
    }

    private String privateString = "privateString";
    String defaultString = "defaultString";
    protected String protectedString = "protectedString";
    public String publicString = "publicString";

    protected String getPString() {
        return privateString;
    }

    private String getPrivateString() {
        return privateString;
    }

    String getDefaultString() {
        return defaultString;
    }

    protected String getProtectedString() {
        return protectedString;
    }

    public String getPublicString() {
        return publicString;
    }

    public void sout() {
        System.out.println(getPrivateString());
        System.out.println(getDefaultString());
        System.out.println(getProtectedString());
        System.out.println(getPublicString());
    }
}

class DefaultClass {

    private String privateString = "privateString";
    String defaultString = "defaultString";
    protected String protectedString = "protectedString";
    public String publicString = "publicString";

    private String getPrivateString() {
        return privateString;
    }

    String getDefaultString() {
        return defaultString;
    }

    protected String getProtectedString() {
        return protectedString;
    }

    public String getPublicString() {
        return publicString;
    }

}
