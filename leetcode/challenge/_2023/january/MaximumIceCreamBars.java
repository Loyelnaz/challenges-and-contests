package leetcode.challenge._2023.january;

import java.util.Arrays;

/**
 * At the store, there are n ice cream bars. You are given an array costs of length n,
 * where costs[i] is the price of the ith ice cream bar in coins.
 * The boy initially has coins to spend, and he wants to buy as many ice cream bars as possible.
 *
 * Return the maximum number of ice cream bars the boy can buy with coins.
 *
 * Note: The boy can buy the ice cream bars in any order.
 */
public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int totalBars = 0;
        int currentCoins = coins;

        for (int cost : costs) {
            if (cost > currentCoins) {
                return totalBars;
            }
            currentCoins -= cost;
            totalBars++;
        }

        return totalBars;
    }
}
