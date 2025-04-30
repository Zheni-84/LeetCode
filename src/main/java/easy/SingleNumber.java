package easy;

/**
 * LeetCode Problem 136 - Single Number
 * Topics: Array, Bit Manipulation
 * <p>
 * Description:
 * 	Given a non-empty array of integers nums, every element appears twice except for one.
 *  Find that single one.
 *  You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Link: https://leetcode.com/problems/single-number/
 */

// Given a non-empty array of integers nums, every element appears twice except for one.
public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = {4, 1, 2, 1, 2};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		// Using XOR to find the single number
		int result = 0;
		for (int num : nums) {
			// XORing the number with the result
			// The same numbers will cancel each other out
			// and the single number will remain
			// because x ^ x = 0 and x ^ 0 = x
			// So, the result will be the single number
			// because all other numbers will cancel out
			// For example: 4 ^ 1 ^ 2 ^ 1 ^ 2 = 4
			// 4 ^ 1 = 5
			// 5 ^ 2 = 7
			// 7 ^ 1 = 6
			// 6 ^ 2 = 4
			// So, the result will be 4
			result ^= num;
		}
		return result;
	}
}