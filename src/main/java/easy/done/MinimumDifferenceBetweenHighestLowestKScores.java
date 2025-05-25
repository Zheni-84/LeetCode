package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1984 - Minimum Difference Between Highest and Lowest of K Scores
 * Topics: Array, Sorting, Sliding Window
 * Time Complexity: O(n log n), where n is the length of the input array nums.
 * Space Complexity: O(1), since we are using a constant amount of extra space for variables.
 * <p>
 * Description:
 * Given an integer array nums and an integer k, return the minimum difference between the highest and lowest scores among any k scores in nums.
 * <p>
 * Example:
 * Input: nums = [9, 4, 1, 7], k = 2
 * Output: 3
 * Explanation: The highest score is 9 and the lowest score is 7. The difference is 9 - 7 = 2.
 * <p>
 * Link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class MinimumDifferenceBetweenHighestLowestKScores {

	public static void main(String[] args) {
		int[] nums = { 9, 4, 1, 7 };
		//int k = 2; // Output: 2
		int k = 3; // Output: 5
		int result = minimumDifference(nums, k);
		System.out.println("Minimum difference between highest and lowest " + k + " scores: " + result);
	}

	private static int minimumDifference(int[] nums, int k) {
		if (k == 1) {
			return 0;
		}

		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i <= nums.length - k; i++) {
			int diff = nums[i + k - 1] - nums[i];
			minDiff = Math.min(minDiff, diff);
		}

		return minDiff;
	}
}