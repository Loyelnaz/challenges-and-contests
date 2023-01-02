package leetcode.challenge._2022.november;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/orderly-queue/description/
 */
public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);

                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        }
    }
}
