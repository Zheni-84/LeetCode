package easy.done;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 2215: Find the Difference of Two Arrays
 * Time Complexity: O(n + m), where n and m are the lengths of nums1 and nums2 respectively.
 * Space Complexity: O(n + m) for storing the unique elements in sets.
 * Topics: Array, Hash Table, Two Pointers, Sorting
 *
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * - answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * - answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 *
 * Note that the integers in the lists may be returned in any order.
 *
 * Constraints:
 * - 1 <= nums1.length, nums2.length <= 1000
 * - -1000 <= nums1[i], nums2[i] <= 1000
 *
 * Hint: Use sets to find unique elements in each array and then compute the differences.
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */
public class FindTheDifferenceOfTwoArrays {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 2, 4, 6 };

		System.out.println(findDifference(nums1, nums2));
	}

	public List<List<Integer>> findDifferenceStream(int[] nums1, int[] nums2) {
		Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

		Set<Integer> diff1 = new HashSet<>(set1);
		diff1.removeAll(set2);

		Set<Integer> diff2 = new HashSet<>(set2);
		diff2.removeAll(set1);

		return List.of(new ArrayList<>(diff1), new ArrayList<>(diff2));
	}

	private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int num : nums1) {
			set1.add(num);
		}

		for (int num : nums2) {
			set2.add(num);
		}

		List<Integer> uniqueToNums1 = new ArrayList<>();
		List<Integer> uniqueToNums2 = new ArrayList<>();

		for (int num : set1) {
			if (!set2.contains(num)) {
				uniqueToNums1.add(num);
			}
		}

		for (int num : set2) {
			if (!set1.contains(num)) {
				uniqueToNums2.add(num);
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		result.add(uniqueToNums1);
		result.add(uniqueToNums2);

		return result;
	}
}