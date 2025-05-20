package easy.done;

/**
 * LeetCode Problem 674 - Longest Continuous Increasing Subsequence
 * Topics: Array
 * <p>
 * Description:
 * Given an integer array nums, return the length of the longest continuous increasing subsequence (LCIS).
 * <p>
 * A continuous increasing subsequence is defined as a subsequence that is strictly increasing and consists of consecutive elements.
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,4,7]
 * Output: 5
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * <p>
 * Example 2:
 * Input: nums = [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2] with length 1.
 * <p>
 * Constraints:
 * - 0 <= nums.length <= 104
 * - -109 <= nums[i] <= 109
 * Link: https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class LongestContinuousSubsequence {

	public static void main(String[] args) {
		// Example usage
		int[] nums = { 6, 1, 3, 5, 6, 8, 9, 4, 7 };
		int result = findLengthOfLCIS(nums);
		System.out.println("Length of longest continuous increasing subsequence: " + result); // result = 6
	}

	private static int findLengthOfLCIS(int[] nums) {
		if(nums.length == 0){
			return 0;
		}

		int currentLength = 1;
		int maxLength = 1;

		for(int i = 0; i < nums.length - 1; i++){
			// If the current number is greater than the next number
			if(nums[i] >= nums[i+1]){
				// Reset the current length to 1
				currentLength = 1;
				// Continue to the next iteration
				continue;
			}
			// If the current number is less than the next number
			currentLength++;
			// Update the maximum length if the current length is greater
			if(currentLength > maxLength){
				maxLength = currentLength;
			}
		}
		// Return the maximum length of the continuous increasing subsequence
		return maxLength;
	}
}