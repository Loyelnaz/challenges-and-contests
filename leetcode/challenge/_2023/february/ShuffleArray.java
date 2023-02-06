package leetcode.challenge._2023.february;

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 *
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,2,1};
        int n = 4;

        int[] result = shuffle(nums, n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n), space to store the resultant
     */
    public static int[] shuffle(int[] nums, int n) {
        // result array would be of size 2N
        // as N denotes the size of half the array
        int[] result = new int[2 * n];

        // as we loop through the array,
        // we update i and i+1 indices of the array
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }

        return result;
    }
}
