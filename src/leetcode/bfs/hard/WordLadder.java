package leetcode.bfs.hard;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/04/10
 */
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }

    HashSet<String> wordSet;
    HashSet<String> visited;
    LinkedList<String> queue = new LinkedList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.add(beginWord);
        visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size-- > 0) {
                String first = queue.pollFirst();
                if (arrival(first, endWord)) {
                    return step + 1;
                }
            }
        }
        return 0;
    }

    private boolean arrival(String first, String endWord) {
        if (first.equals(endWord)) {
            return true;
        }
        for (int i = 0; i < first.length(); i++) {
            char[] arr = first.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                if (arr[i] == j) {
                    continue;
                }
                arr[i] = j;
                String o = String.valueOf(arr);
                if (o.equals(endWord)) {
                    return true;
                }
                if (wordSet.contains(o) && !visited.contains(o)) {
                    queue.offerLast(o);
                    visited.add(o);
                }
            }
        }
        return false;
    }
}
