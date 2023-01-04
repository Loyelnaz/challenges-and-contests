package leetcode.challenge._2023.january;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
 * In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 *
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 */
public class MinimumRoundsToCompleteAllTasks {
    public static void main(String[] args) {
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(tasks));
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        int minRounds = 0;
        for (int count : frequency.values()) {
            // If the frequency is 1, it's not possible to complete all tasks
            // as in one round we can either complete 2 or 3 tasks of the same difficulty level
            if (count == 1) {
                return -1;
            }

            // complete as many tasks as possible by taking them as triplets
            minRounds += count / 3;

            // once we have considered the triplets, only other valid possibilities
            // would be of 1 or 2 tasks that would be left over which we could finish in a single round
            if (count % 3 != 0) {
                minRounds++;
            }
        }

        return minRounds;
    }
}
