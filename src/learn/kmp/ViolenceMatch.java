package learn.kmp;

/**
 * @author 窦康泰
 * @date 2020/10/09
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String s1 = "abcdefghi";
        String s2 = "cde";
        int i = violenceMatch(s1, s2);
        System.out.println(i);
    }

    public static int violenceMatch(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == c2.length) {
            return i - j;
        } else {
            return -1;
        }
    }

}
