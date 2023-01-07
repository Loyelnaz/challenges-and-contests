package leetcode.challenge._2023.january;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        // calculate total gas and total cost required for the journey
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // if the total gas is less than the total cost,
        // we will not be able to complete the journey
        // as we would run out of gas midway
        if (totalGas < totalCost) {
            return -1;
        }

        int startIndex = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            // calculate the gas at the ith index
            tank += (gas[i] - cost[i]);

            // at any point, if the gas in the tank goes below 0,
            // we can conclude that we cannot travel further.
            // That means the current start station isn't the one,
            // and we would need to reset out start station
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }

        return startIndex;
    }
}
