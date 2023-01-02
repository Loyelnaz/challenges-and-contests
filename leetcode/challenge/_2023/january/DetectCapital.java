package leetcode.challenge._2023.january;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 *
 * Given a string word, return true if the usage of capitals in it is right.
 */
public class DetectCapital {
    public static void main(String[] args) {
        String word = "leetcode";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        int wordLength = word.length();
        int count = 0, location = 0;

        for (int i = 0; i < wordLength; i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
                location = i;
            }
        }

        if (count == wordLength || count == 0 || (count == 1 && location == 0)) {
            return true;
        }

        return false;
    }
}
