package leetcode.challenge._2022.november;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int length = 0;
        Map<String, Integer> map = new HashMap<>();
        boolean found = false;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            String str = (String)entry.getKey();
            String reversedStr = reverseString(str);

            if (!str.equals(reversedStr) && map.containsKey(reversedStr)) {
                if (map.get(str) > 0 && map.get(reversedStr) > 0) {
                    int minCount = Math.min(map.get(str), map.get(reversedStr));

                    map.put(str, map.getOrDefault(str, 0) - minCount);
                    map.put(reversedStr, map.getOrDefault(reversedStr, 0) - minCount);

                    length += minCount * 4;
                }
            } else if (str.equals(reversedStr)) {
                int count = map.get(str);
                length += (count / 2) * 4;

                if (count % 2 != 0 && !found) {
                    found = true;
                    length += 2;
                }
            }
        }
        return length;
    }

    private String reverseString(String str) {
        return String.valueOf(str.charAt(1) + String.valueOf(str.charAt(0)));
    }
}
