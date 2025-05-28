package easy.done;


/**
 * LeetCode 1413: Minimum Value to Get Positive Step by Step Sum
 * Topics: Array, Prefix Sum
 * <p>
 * Time Complexity: O(n), where n is the length of nums.
 * Space Complexity: O(1)
 * <p>
 * This class provides a method to find the minimum positive start value such that
 * the step-by-step sum of the given integer array is always greater than or equal to 1.
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class MinimumValueToPositiveStepSum {

	public static void main(String[] args) {
		int[] nums = {-3, 2, -3, 4, 2};
		System.out.println(minStartValue(nums)); // Output: 5

		int[] nums2 = {1, 2};
		System.out.println(minStartValue(nums2)); // Output: 1

		int[] nums3 = {1, -2, -3};
		System.out.println(minStartValue(nums3)); // Output: 5
	}

	private static int minStartValue(int[] nums) {
		// We will calculate the cumulative sum and track the minimum sum encountered
		int minSum = 0;
		int currSum = 0;
		for(int num : nums){
			currSum += num;
			minSum = Math.min(minSum, currSum);
		}

		// If the minimum sum is less than 1, we need to return the positive value
		return Math.max(1, 1 - minSum);
	}
}