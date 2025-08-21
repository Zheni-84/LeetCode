package easy.done;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 1 - Two Sum
 * Topics: Array, Hash Table
 * <p>
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Hint: You can use a brute force approach to check all pairs of numbers, but this is not efficient for large arrays.
 * Link: https://leetcode.com/problems/two-sum/
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int target = 9;

		int[] result1 = ts.twoSumStoreNeed(nums, target);
		int[] result2 = ts.twoSumOptimal(nums, target);

		System.out.println("Store Need version: [" + result1[0] + ", " + result1[1] + "]");
		System.out.println("Store Seen version: [" + result2[0] + ", " + result2[1] + "]");
	}

	/*
	 *Time Complexity: O(n) - This solution uses one loop
	 * Space Complexity: O(n) - This solution uses a map of indexes
	 */
	public static int[] twoSumOptimal(int[] nums, int target) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int sum = target - nums[i];
			if (indexMap.containsKey(sum)) {
				return new int[] { indexMap.get(sum), i };
			}

			indexMap.put(nums[i], i);
		}

		return new int[0];
	}

	// Another version: store the "number to find"
	public int[] twoSumStoreNeed(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();

		for (int p = 0; p < nums.length; p++) {
			if (numsMap.containsKey(nums[p])) {
				return new int[]{numsMap.get(nums[p]), p};
			} else {
				int numberToFind = target - nums[p];
				numsMap.put(numberToFind, p);
			}
		}
		return null;
	}

	/*
	 *Time Complexity: O(n^2) - This solution uses a nested loop to find the two indices.
	 * Space Complexity: O(1) - This solution does not use any additional data structures or storage.
	 */
	public static int[] twoSumBrute(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			int sum = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == sum) {
					return new int[] { i, j };
				}
			}
		}

		return new int[0];
	}
}
