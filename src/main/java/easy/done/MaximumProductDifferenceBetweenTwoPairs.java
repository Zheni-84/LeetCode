package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1913 - Maximum Product Difference Between Two Pairs
 * Topics: Array, Sorting
 * Time Complexity: O(n log n) - for sorting the array, where n is the length of the input array.
 * Space Complexity: O(1) - in-place sorting.
 * <p>
 * Description:
 * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d),
 * where a, b, c, and d are elements of an integer array nums.
 * <p>
 * Return the maximum product difference among all possible pairs of numbers at different positions in nums.
 * <p>
 * Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 */
public class MaximumProductDifferenceBetweenTwoPairs {

	public static void main(String[] args) {
		int[] nums = { 5, 6, 2, 7, 4 };
		// Example usage
		// Output: 34
		// Explanation: The maximum product difference can be obtained by:
		// (6 * 7) - (2 * 4) = 42 - 8 = 34
		System.out.println("Maximum Product Difference Between Two Pairs: " + maxProductDifference(nums));
	}

	private static int maxProductDifference(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		return nums[len - 2] * nums[len - 1] - nums[0] * nums[1];
	}
}