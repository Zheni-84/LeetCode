package easy.done;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 219 - Contains Duplicate II
 * Topics: Array, HashMap Table
 * Time complexity: O(n) - where n is the length of the input array.
 * Time complexity (brute force): O(n*k) - where n is the length of the input array and k is the maximum distance.
 * Space complexity: O(n) - where n is the length of the input array.
 * <p>
 * Description:
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Link: https://leetcode.com/problems/contains-duplicate-ii/
 **/
public class ContainsDuplicate2 {

	public static void main(String[] args) {
		// Example usage
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;
		//boolean result = containsNearbyDuplicateBruteForce(nums, k);
		boolean result = containsNearbyDuplicate(nums, k);
		System.out.println("Contains nearby duplicate: " + result); // Output: true
	}

	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		// Create a HashMap to store the last index of each number
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			// Check if the number is already in the map
			Integer numIndex = map.get(num);
			if (map.containsKey(num) && i - numIndex <= k) {
				return true;
			}

			// Add/Update the last index of the number
			map.put(num, i);
		}
		// If no duplicates are found within the given distance, return false
		return false;
	}

	private static boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
		int i = 0;
		int j = 1;
		int len = nums.length;

		while (i < len - 1 && j < len) {
			int numI = nums[i];
			int numJ = nums[j];
			int absIJ = Math.abs(i - j);
			// Check if the numbers are equal and the absolute difference is less than or equal to k
			if (numI == numJ && absIJ <= k) {
				return true;
			}
			// Move i to the next index, reset j to i + 1
			if (j == i + k) {
				i++;
				j = i + 1;
			} else {
				// Move j to the next index
				j++;
			}
		}
		// we did not find any duplicates within the given distance
		return false;
	}
}