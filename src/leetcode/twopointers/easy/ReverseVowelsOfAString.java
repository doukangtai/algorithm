package leetcode.twopointers.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/29
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        List<Character> con = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        while (left <= right) {
            boolean conLeft = con.contains(arr[left]);
            boolean conRight = con.contains(arr[right]);
            if (conLeft && conRight) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (!conLeft) {
                left++;
            } else if (!conRight) {
                right--;
            }
        }
        return new String(arr);
    }
}
