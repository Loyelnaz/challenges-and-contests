package leetcode.challenge._2023.january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 * Input: pattern = "abba", s = "dog dog dog dog"
 * Output: false
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = s.split("\\s");
        int k = 0, patternLength = pattern.length();

        if (patternLength != words.length) {
            return false;
        }

        for (String word : words) {
            if (k != patternLength) {
                char ch = pattern.charAt(k);
                if (map.containsKey(ch)) {
                    String value = map.get(ch);

                    if (!value.equals(word)) {
                        return false;
                    }
                } else {
                    map.put(ch, word);

                    if (!set.add(word)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            k++;
        }

        return true;
    }
}
