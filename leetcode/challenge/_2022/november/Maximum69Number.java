package leetcode.challenge._2022.november;

/**
 * https://leetcode.com/problems/maximum-69-number/description/
 */
public class Maximum69Number {
    public int maximum69Number (int num) {
        int firstSixPosition = -1;
        int count = 0;
        int temp = num;

        while (temp > 0) {
            int remainder = temp % 10;
            if (remainder == 6) {
                firstSixPosition = count;
            }
            count++;
            temp = temp / 10;
        }

        if (firstSixPosition != -1) {
            num = num += (3 * Math.pow(10, firstSixPosition));
        }

        return num;
    }
}
