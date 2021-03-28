package leetcode.binarysearch.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/28
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }

    List<Integer>[] index;

    public boolean isSubsequence(String s, String t) {
        index = new List[128];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c] != null) {
                List<Integer> indexList = this.index[c];
                int temp = searchBound(indexList, j);
                if (temp == indexList.size()) {
                    return false;
                }
                j = indexList.get(temp) + 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private int searchBound(List<Integer> indexList, int j) {
        int left = 0;
        int right = indexList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Integer midVal = indexList.get(mid);
            if (midVal < j) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
