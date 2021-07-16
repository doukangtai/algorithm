package leetcode.str.easy;

/**
 * @author 窦康泰
 * @date 2021/03/29
 */
public class ValidPalindromeii {
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeii().validPalindrome("ebcbbececabbacecbbcbe"));
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left <= right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else {
                if (isValid(s.substring(left, right)) || isValid(s.substring(left + 1, right + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
