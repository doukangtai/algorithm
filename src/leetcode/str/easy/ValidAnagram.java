package leetcode.str.easy;

/**
 * @author 窦康泰
 * @date 2021/07/16
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        for (char c : s.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr1[c - 'a']--;
        }
        for (int arr : arr1) {
            if (arr != 0) {
                return false;
            }
        }
        return true;
    }
}
