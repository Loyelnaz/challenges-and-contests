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

    /**
     * Time Complexity - O(n*logn), since we are sorting the costs array
     * Space Complexity - O(logn), variant of Quick Sort is used in Java for sorting,
                          which takes about logn space
     */
    public static int maxIceCream(int[] costs, int coins) {
        // Store ice cream costs in increasing order
        Arrays.sort(costs);

        int iceCreamBars = 0;
        int currentCoins = coins;
        for (int cost : costs) {
            // Pick ice creams till we can
            if (cost > currentCoins) {
                return iceCreamBars;
            }
            currentCoins -= cost;
            iceCreamBars++;
        }

        return iceCreamBars;
    }
}
