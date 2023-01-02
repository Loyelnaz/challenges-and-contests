package leetcode.challenge._2022.november;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        boolean flag = false;
        for (String bankElement : bank) {
            if (bankElement.equals(end)) {
                flag = true;
            }
        }

        if (!flag) {
            return -1;
        }

        boolean[] visited = new boolean[bank.length];
        int minOperation = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();

                if (current.equals(end)) {
                    return minOperation;
                }

                int bankLength = bank.length;
                for (int i = 0; i < bankLength; i++) {
                    String bankElement = bank[i];

                    if (!visited[i]) {
                        int differenceCount = isGeneMutation(current, bankElement);

                        if (differenceCount == 1) {
                            queue.add(bankElement);
                            visited[i] = true;
                        }
                    }
                }
            }

            minOperation++;
        }

        return -1;
    }

    public int isGeneMutation(String current, String bankElement) {
        int index = 0;
        int differenceCount = 0;

        int currentLength = current.length();
        while (index < currentLength) {
            if (current.charAt(index) != bankElement.charAt(index)) {
                differenceCount++;

                if (differenceCount > 1) {
                    return 0;
                }
            }

            index++;
        }

        return differenceCount;
    }
}
