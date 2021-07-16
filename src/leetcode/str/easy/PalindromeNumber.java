package leetcode.str.easy;

/**
 * @author 窦康泰
 * @date 2021/07/16
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String strNum = x + "";
        int l = 0;
        int r = strNum.length() - 1;
        while (l <= r) {
            if (strNum.charAt(l) != strNum.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
