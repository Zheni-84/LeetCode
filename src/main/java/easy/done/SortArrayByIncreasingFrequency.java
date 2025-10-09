package easy.done;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 1636: Sort Array by Increasing Frequency
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(n) for frequency map and sorting
 * Topics: Array, Hash Table, Sorting
 *
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 * Return the sorted array.
 *
 * Example:
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 *
 * Hint: Use a frequency map to count occurrences and then sort with a custom comparator.
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 */
public class SortArrayByIncreasingFrequency {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2, 3 };
		int[] sorted = frequencySort1(nums);
		// Alternatively, you can use frequencySort2 or frequencySort3
		// int[] sorted = frequencySort2(nums);
		// int[] sorted = frequencySort3(nums);
		System.out.println("Sorted by frequency: " + Arrays.toString(sorted)); // Output: [3,1,1,2,2,2]
	}

	private static int[] frequencySort1(int[] nums) {
		Map<Integer, Long> freq = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		return Arrays.stream(nums)
				.boxed()
				// sort by frequency ascending
				.sorted((a, b) -> {
							int fa = freq.get(a).intValue();
							int fb = freq.get(b).intValue();
							if (fa != fb)
								return fa - fb; // increasing freq

							return b - a; //decreasing value
						}
				)
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static int[] frequencySort2(int[] nums) {
		Map<Integer, Long> freq = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		return Arrays.stream(nums)
				.boxed()
				.sorted(Comparator.comparingLong((Integer n) -> freq.get(n))
						.thenComparing(Comparator.<Integer>reverseOrder()))
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static int[] frequencySort3(int[] nums) {
		// Step 1: Count frequencies
		Map<Integer, Integer> freq = new HashMap<>();
		for (int n : nums) {
			freq.put(n, freq.getOrDefault(n, 0) + 1);
		}

		// Step 2: Convert to a list to sort
		List<Integer> list = new ArrayList<>();
		for (int n : nums) list.add(n);

		// Step 3: Sort using custom comparator
		Collections.sort(list, (a, b) -> {
			int fa = freq.get(a);
			int fb = freq.get(b);
			if (fa != fb) {
				return fa - fb; // increasing frequency
			} else {
				return b - a;   // decreasing value
			}
		});

		// Step 4: Copy back to array
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
