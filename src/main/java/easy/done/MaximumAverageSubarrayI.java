package easy.done;

/**
 * LeetCode Problem 643 - Maximum Average Subarray I
 * Topics: Array, Sliding Window
 * Given an integer array nums consisting of n elements and an integer k,
 * return the maximum average value of any contiguous subarray of length k.
 * Any answer with a calculation error less than 10^-5 will be accepted.
 * Time complexity: O(n)
 * Space complexity: O(1)
 * <p>
 * Example:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * LeetCode Link: https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println("Maximum Average Subarray: " + findMaxAverage(nums, k)); // Output: 12.75
	}

	/**
	 * Function to find the maximum average of any contiguous subarray of length k.
	 *
	 * @param nums An array of integers.
	 * @param k    The length of the subarray.
	 * @return The maximum average value of any contiguous subarray of length k.
	 */
	private static double findMaxAverage(int[] nums, int k) {
		double maxSum = 0;
		// Calculate the sum of the first k elements
		for (int i = 0; i < k; i++) {
			maxSum += nums[i];
		}

		double sum = maxSum;

		for (int i = k; i < nums.length; i++) {
			sum = sum - nums[i - k] + nums[i];
			maxSum = Math.max(maxSum, sum);
		}

		// Return the maximum average
		return maxSum / k;
	}
}
