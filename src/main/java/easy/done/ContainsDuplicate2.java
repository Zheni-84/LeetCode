package easy.done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;
		// Output: true
		// Explanation: There are two 1's in the array, and their indices are 0 and 3. The absolute difference between their indices is |0 - 3| = 3, which is less than or equal to k.
		System.out.println("Contains Duplicate II: " + containsNearbyDuplicateSet(nums, k));

		nums = new int[] { 1, 0, 1, 1 };
		k = 1;
		// Output: true
		// Explanation: There are two 1's in the array, and their indices are 0 and 2. The absolute difference between their indices is |0 - 2| = 2, which is greater than k.
		System.out.println("Contains Duplicate II: " + containsNearbyDuplicateMap(nums, k));

		nums = new int[] { 1, 2, 3, 1, 2, 3 };
		k = 2;
		// Output: false
		// Explanation: There are no two distinct indices i and j in the array such that nums[i] == nums[j] and the absolute difference between i and j is less than or equal to k.
		System.out.println("Contains Duplicate II: " + containsNearbyDuplicateBruteForce(nums, k));
	}

	// Sliding window approach using a HashSet to maintain a window of size k
	// This approach has a time complexity of O(n) and space complexity of O(min(n, k))
	// Time Complexity: O(n)
	// Space Complexity: O(min(n, k))
	private static boolean containsNearbyDuplicateSet(int[] nums, int k) {
		Set<Integer> window = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (window.contains(nums[i]))
				return true;

			window.add(nums[i]);

			if (window.size() > k)
				window.remove(nums[i - k]);
		}

		return false;
	}

	// Alternative solution using a HashMap to store the last seen index of each number
	// This approach also has a time complexity of O(n) and space complexity of O(n)
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static boolean containsNearbyDuplicateMap(int[] nums, int k) {
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

	// Brute force approach checking all pairs within distance k
	// This approach has a time complexity of O(n*k) and space complexity of O(1)
	// Time Complexity: O(n*k)
	// Space Complexity: O(1)
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