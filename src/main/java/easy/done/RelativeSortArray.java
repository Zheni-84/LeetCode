package easy.done;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode Problem 1122 - Relative Sort Array
 * Time complexity: O(n + m + k) - where n is the length of arr1, m is the length of arr2, and k is the range of numbers (in this case, 1001).
 * Space complexity: O(k) - for the counting array.
 * Topics: Array, HashMap Table, Sorting, Counting Sort
 *
 * Description:
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * Hint: You can use a counting sort approach since the range of elements is limited (0 to 1000).
 * Link: https://leetcode.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };

		System.out.println("Relative Sort Array (Counting Sort): " + Arrays.toString(relativeSortArray(arr1.clone(), arr2)));
		System.out.println("Relative Sort Array (Map + Custom Sort): " + Arrays.toString(relativeSortArrayMap(arr1.clone(), arr2)));
		System.out.println("Relative Sort Array (Map + Custom Sort 2): " + Arrays.toString(relativeSortArrayMap2(arr1.clone(), arr2)));
	}

	// Using HashMap to store the order of elements in arr2 and custom sorting arr1 based on that order
	// Time Complexity: O(n log n) due to sorting
	// Space Complexity: O(m) for the order map
	private static int[] relativeSortArrayMap(int[] arr1, int[] arr2) {
		Map<Integer, Integer> order = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			order.put(arr2[i], i);
		}

		Integer[] boxed = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
		Arrays.sort(boxed, (a, b) -> {
			if (order.containsKey(a) && order.containsKey(b)) {
				return order.get(a) - order.get(b);
			} else if (order.containsKey(a)) {
				return -1;
			} else if (order.containsKey(b)) {
				return 1;
			} else {
				return a - b;
			}
		});

		return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
	}

	// Using Java Streams for a more functional approach
	// Time Complexity: O(n log n) due to sorting
	// Space Complexity: O(n) for the boxed array
	private static int[] relativeSortArrayMap2(int[] arr1, int[] arr2) {
		Map<Integer, Integer> arr2Idx = new TreeMap<>();
		for (int i = 0; i < arr2.length; i++) {
			arr2Idx.put(arr2[i], i);
		}

		return Arrays.stream(arr1)
				.boxed()
				.sorted((a, b) -> {
					int weightA = arr2Idx.getOrDefault(a, arr2.length + a);
					int weightB = arr2Idx.getOrDefault(b, arr2.length + b);
					return Integer.compare(weightA, weightB);
				})
				.mapToInt(Integer::intValue).toArray();
	}

	// Counting sort approach
	// Time Complexity: O(n + m + k) - where n is the length of arr1, m is the length of arr2, and k is the range of numbers (in this case, 1001).
	// Space Complexity: O(k) - for the counting array
	private static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] count = new int[1001];
		for (int num : arr1) {
			count[num]++;
		}

		int index = 0;
		for (int num : arr2) {
			while (count[num] > 0) {
				arr1[index++] = num;
				count[num]--;
			}
		}

		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				arr1[index++] = i;
				count[i]--;
			}
		}

		return arr1;
	}
}