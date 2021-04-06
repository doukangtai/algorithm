package leetcode.binarysearch.easy;

/**
 * @author 窦康泰
 * @date 2021/04/06
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == letters.length) {
            return letters[0];
        } else {
            return letters[left];
        }
    }
}
