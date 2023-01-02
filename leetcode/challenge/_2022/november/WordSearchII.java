package leetcode.challenge._2022.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 */
public class WordSearchII {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;

        TrieNode() {}
    }

    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // construct a trie
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                if (current.children.containsKey(ch)) {
                    current = current.children.get(ch);
                } else {
                    TrieNode newNode = new TrieNode();
                    current.children.put(ch, newNode);
                    current = newNode;
                }
            }
            current.word = word;
        }

        int m = board.length;
        int n = board[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(board, row, col, root);
                }
            }
        }

        return result;
    }

    private void backtracking(char[][] board, int row, int col, TrieNode parent) {
        Character letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        board[row][col] = '#';

        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0
                    || newCol >= board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(board[newRow][newCol])) {
                backtracking(board, newRow, newCol, currNode);
            }
        }

        board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
