package easy.done;

import java.util.HashSet;

/**
 * LeetCode Problem 217 - Contains Duplicate
 * Topics: Array, HashSet Table
 * Time complexity: O(n) - where n is the length of the input array.
 * Space complexity: O(n) - where n is the length of the input array.
 *
 * Description:
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Hint: Use a HashSet to track seen numbers as you iterate through the array.
 * Link: https://leetcode.com/problems/contains-duplicate/
 **/
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		// Output: true
		// Explanation: There are two 1's in the array, and their indices are 0 and 3.
		System.out.println("Contains Duplicate: " + containsDuplicate(nums));

		nums = new int[]{1, 2, 3, 4};
		// Output: false
		// Explanation: There are no duplicates in the array.
		System.out.println("Contains Duplicate: " + containsDuplicate(nums));

		nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
		// Output: true
		// Explanation: There are multiple duplicates in the array.
		System.out.println("Contains Duplicate: " + containsDuplicate(nums));
	}

	private static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			}
			set.add(num);
		}
		return false;
	}
}
