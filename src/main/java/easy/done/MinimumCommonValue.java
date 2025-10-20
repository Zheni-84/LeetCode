package easy.done;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem 1762: Find Minimum Common Value
 * Time Complexity: O(n + m) where n and m are the lengths of nums1 and nums2
 * Space Complexity: O(n) for the HashSet approach, O(1) for the Two Pointers approach
 * Topics: Array, Hash Table, Two Pointers, Sorting
 *
 * Given two integer arrays nums1 and nums2, return the minimum integer that appears in both arrays.
 * If there is no common integer between the two arrays, return -1.
 *
 * Example:
 * Input: nums1 = [1,2,3], nums2 = [2,4]
 * Output: 2
 *
 * Hint: Use a HashSet to store elements of one array and then check for common elements in the other array.
 * Alternatively, sort both arrays and use two pointers to find the minimum common element.
 * https://leetcode.com/problems/find-minimum-common-value/
 */
public class MinimumCommonValue {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 2, 4 };

		System.out.println("Minimum common value (Stream): " + getCommonStreams(nums1, nums2)); // Output: 2
		System.out.println("Minimum common value (HashSet): " + getCommonHashSet(nums1, nums2)); // Output: 2
		System.out.println("Minimum common value (Two Pointers): " + getCommonTwoPointers(
				Arrays.stream(nums1).sorted().toArray(),
				Arrays.stream(nums2).sorted().toArray())); // Output: 2
	}
	private static int getCommonStreams(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.stream(nums1).forEach(set::add);

		return Arrays.stream(nums2)
				.filter(set::contains)
				.findFirst()
				.orElse(-1);
	}

	// Time: O(n + m) where n and m are the lengths of nums1 and nums2
	// Space: O(1)
	// HashSet approach
	private static int getCommonHashSet(int[] nums1, int[] nums2) {
		java.util.Set<Integer> set = new java.util.HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			if (set.contains(num)) {
				return num;
			}
		}

		return -1;
	}

	// Time: O(n + m) where n and m are the lengths of nums1 and nums2
	// Space: O(1)
	// Two pointers approach
	private static int getCommonTwoPointers(int[] nums1, int[] nums2) {
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				return nums1[i];
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		return -1;
	}
}