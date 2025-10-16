package easy.done;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 2441: Largest Positive Integer That Exists With Its Negative
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Topics: Array, Hash Table
 * <p>
 * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
 * Return the positive integer k. If there is no such integer, return -1.
 * <p>
 * Example:
 * Input: nums = [-1,2,-3,3]
 * Output: 3
 * Explanation: 3 is the only valid k we can find in the array.
 * <p>
 * Hint: Use a set to track the numbers and check for each positive number if its negative counterpart exists.
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

	public static void main(String[] args) {
		int[] nums1 = { -1, 2, -3, 3 };
		int[] nums2 = { -1, 10, 6, 7, -7, 1 };
		int[] nums3 = { -10, 8, 6, 7, -2, -3 };

		System.out.println("Max K (Approach 1): " + findMaxK(nums1)); // Output: 3
		System.out.println("Max K (Approach 1): " + findMaxK(nums2)); // Output: 7
		System.out.println("Max K (Approach 1): " + findMaxK(nums3)); // Output: -1

		System.out.println("Max K (Stream Approach 1): " + findMaxKStream(nums1)); // Output: 3
		System.out.println("Max K (Stream Approach 1): " + findMaxKStream(nums2)); // Output: 7
		System.out.println("Max K (Stream Approach 1): " + findMaxKStream(nums3)); // Output: -1

		System.out.println("Max K (Stream Approach 2): " + findMaxKStream2(nums1)); // Output: 3
		System.out.println("Max K (Stream Approach 2): " + findMaxKStream2(nums2)); // Output: 7
		System.out.println("Max K (Stream Approach 2): " + findMaxKStream2(nums3)); // Output: -1
	}

	private static int findMaxK(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		int max = -1;

		for (int num : nums) {
			if (seen.contains(-num)) {
				max = Math.max(max, Math.abs(num));
			}
			seen.add(num);
		}
		return max;
	}

	private static int findMaxKStream(int[] nums) {
		Set<Integer> set = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.toSet());

		return set.stream()
				.filter(num -> num > 0 && set.contains(-num))
				.max(Comparator.naturalOrder()) // here use max(Comparator.naturalOrder()) because it's a stream of Integer
				// and max() returns an Optional<Integer>, which requires a comparator
				.orElse(-1);
	}

	private static int findMaxKStream2(int[] nums) {
		Set<Integer> set = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.toSet());

		return Arrays.stream(nums)
				.filter(num -> num > 0 && set.contains(-num))
				.max()// here use max() instead of max(Comparator.naturalOrder()) because it's an int stream
				// and max() returns an OptionalInt, which does not require a comparator
				.orElse(-1);
	}
}