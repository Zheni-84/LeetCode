package easy.done;

/**
 * LeetCode Problem 2760 - Longest Even Odd Subarray with Threshold
 * Topics: Array, Sliding Window
 * Time Complexity Optimal: O(n), where n is the length of the input array nums.
 * Time Complexity Brute Force: O(n^2), where n is the length of the input array nums.
 * Space Complexity: O(1), since we are using a constant amount of extra space for variables.
 *
 * Description:
 * Given an integer array nums and an integer threshold, return the length of the longest subarray that alternates between even and odd numbers,
 * and all numbers in the subarray are less than or equal to the threshold.
 *
 * Example:
 * Input: nums = [1, 2, 3, 4, 5, 6, 7, 8], threshold = 7
 * Output: 6
 * Explanation: The longest alternating subarray is [2, 3, 4, 5, 6, 7].
 *
 * Link: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
 */
public class LongestEvenOddSubarrayWithThreshold {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int threshold = 7;

		int result = longestAlternatingSubarrayBrute(nums, threshold);
		//int result = longestAlternatingSubarrayOptimal(nums, threshold); // Uncomment to use the optimal solution

		System.out.println("Length of the longest alternating subarray: " + result);
	}

	private static int longestAlternatingSubarrayBrute(int[] nums, int threshold) {
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			// If the number is odd or greater than the threshold, skip it
			if (nums[i] % 2 != 0 || nums[i] > threshold)
				continue;

			// Start counting the length of the subarray
			int len = 1;

			for (int j = i + 1; j < nums.length; j++) {
				// If the next number is greater than the threshold or has the same parity as the previous number, break
				if (nums[j] > threshold || nums[j] % 2 == nums[j - 1] % 2)
					break;
				len++;
			}
			maxLen = Math.max(maxLen, len);
		}

		return maxLen;
	}

	private static int longestAlternatingSubarrayOptimal(int[] nums, int threshold) {
		int max = 0;
		int currentLength = 0;

		for (int i = 0; i < nums.length; i++) {
			// If the number is greater than the threshold, reset the current length
			if (nums[i] > threshold) {
				currentLength = 0; // break condition
				continue;
			}

			// If the current length is 0, check if the number is even
			if (currentLength == 0) {
				if (nums[i] % 2 == 0) {
					// Start a new subarray if the number is even
					currentLength = 1;
					max = Math.max(max, currentLength);
				}
			} else {
				int prev = nums[i - 1];
				// Check if the current number has a different parity than the previous number
				if ((nums[i] % 2 != prev % 2)) {
					currentLength++;
					max = Math.max(max, currentLength);
				} else {
					// If the parity is the same, reset the current length
					if (nums[i] % 2 == 0) {
						currentLength = 1;
						max = Math.max(max, currentLength);
					} else {
						// If the current number is odd, reset the current length
						currentLength = 0;
					}
				}
			}
		}

		return max;
	}
}