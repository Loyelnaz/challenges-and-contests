package leetcode.challenge._2022.november;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();

        int start = 0, end = ch.length - 1;
        while (start < end) {
            while (start < end && !isVowel(ch[start])) {
                start++;
            }

            while (start < end && !isVowel(ch[end])) {
                end--;
            }

            if (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
            }

            start++;
            end--;
        }

        return String.valueOf(ch);
    }

    private boolean isVowel(char ch) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        ch = Character.toLowerCase(ch);

        return set.contains(ch);
    }
}
