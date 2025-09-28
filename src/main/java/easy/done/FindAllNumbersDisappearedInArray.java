package easy.done;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode Problem 448: Find All Numbers Disappeared in an Array
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), since we are modifying the input array in place and using only a fixed amount of extra space.
 * Topics: Array, Hash Table
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - 1 <= nums[i] <= n
 *
 * Hint: Use the input array itself to track which numbers have been seen by negating the value at the index corresponding to each number.
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInArray {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println("Disappeared Numbers: " + findDisappearedNumbers(nums)); // Output: [5,6]
		System.out.println("Disappeared Numbers (Set Method): " + findDisappearedNumbersSet(nums)); // Output: [5,6]
		nums = new int[] { 1, 1 };
		System.out.println("Disappeared Numbers: " + findDisappearedNumbers(nums)); // Output: [2]
		System.out.println("Disappeared Numbers (Set Method): " + findDisappearedNumbersSet(nums)); // Output: [2]
	}

	private static List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		// First pass: mark visited numbers
		for (int num : nums) {
			int idx = Math.abs(num) - 1;   // map number to index
			if (nums[idx] > 0) {
				nums[idx] *= -1;          // flip sign if not already marked
			}
		}

		// Second pass: collect indices that were never marked
		List<Integer> missing = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				missing.add(i + 1);       // convert index back to number
			}
		}

		return missing;
	}

	private static List<Integer> findDisappearedNumbersSet(int[] nums) {
		Set<Integer> seen = new HashSet<>();

		// Step 1: Add all numbers to set
		for (int num : nums) {
			seen.add(num);
		}

		// Step 2: Find missing numbers
		List<Integer> missing = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if (!seen.contains(i)) {
				missing.add(i);
			}
		}

		return missing;
	}
}