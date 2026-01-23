package easy.done;

/**
 * LeetCode Problem 961: N-Repeated Element in Size 2N Array
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Topics: Array, Hash Table, Math
 * Given an integer array nums of length 2 * n, return the element that appears twice.
 *
 * Example 1:
 * Input: nums = [1,2,3,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,1,2,5,3,2]
 * Output: 2
 *
 * Constraints:
 * - 2 <= n <= 5000
 * - nums.length == 2 * n
 * - 0 <= nums[i] <= 10^4
 * - nums contains n + 1 unique elements and one of them is repeated exactly n times.
 *
 * Hint: Use a hash table to store the elements.
 * Link: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */

public class NRepeatedElementInSize2NArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3 };
		System.out.println("N-Repeated Element: " + repeatedNTimes(nums)); // Output: 3

		nums = new int[] { 2, 1, 2, 5, 3, 2 };
		System.out.println("N-Repeated Element: " + repeatedNTimes(nums)); // Output: 2

		nums = new int[] { 5, 1, 5, 2, 5, 3, 5, 4 };
		System.out.println("N-Repeated Element: " + repeatedNTimes(nums)); // Output: 5
	}

	// Use Hash Table
	private static int repeatedNTimesHashTable(int[] nums) {
		java.util.HashSet<Integer> seen = new java.util.HashSet<>();
		for (int num : nums) {
			if (seen.contains(num)) {
				return num;
			}
			seen.add(num);
		}

		return -1; // This line should never be reached given the problem constraints
	}

	private static int repeatedNTimes(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
				return nums[i];
			}
		}
		return nums[n - 1]; // The last element must be the repeated one
	}
}