package leetcode.greedy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/05
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ) {
            int limit = arr[S.charAt(i) - 'a'];
            for (int j = i; j <= limit; j++) {
                limit = Math.max(limit, arr[S.charAt(j) - 'a']);
            }
            res.add(limit - i + 1);
            i = limit + 1;
        }
        return res;
    }
}
