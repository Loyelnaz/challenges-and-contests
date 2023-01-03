package leetcode.challenge._2023.january;

public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String[] strs = {"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs));
    }

    public static int minDeletionSize(String[] strs) {
        int deleteColCount = 0;
        int col = 0, stringLength = strs[0].length();

        while (col < stringLength) {
            for (int row = 0; row < strs.length - 1; row++) {
                String currentString = strs[row];
                String nextString = strs[row + 1];
                if (col < stringLength && currentString.charAt(col) > nextString.charAt(col)) {
                    deleteColCount++;
                    break;
                }
            }
            col++;
        }

        return deleteColCount;
    }
}
