package easy.done;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode Problem 2053: Kth Distinct String in an Array
 * Time Complexity: O(n), where n is the number of strings in the array.
 * Space Complexity: O(n) for the frequency map.
 * Topics: Array, Hash Table, String
 *
 * A distinct string is a string that is present only once in an array.
 * Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
 * If there are fewer than k distinct strings, return an empty string "".
 *
 * Example:
 * Input: arr = ["d","b","c","b","c","a"], k = 2
 * Output: "a"
 * Explanation:
 * The only distinct strings in arr are "d" and "a".
 * The 2nd distinct string is "a".
 *
 * Hint: Use a frequency map to count occurrences of each string, then filter for distinct strings.
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/
 */
public class KthDistinctStringInAnArray {

	public static void main(String[] args) {
		String[] arr1 = { "d", "b", "c", "b", "c", "a" };
		int k1 = 2;
		System.out.println("Kth distinct string: " + kthDistinctStreams(arr1, k1)); // Output: "a"

		String[] arr2 = { "aaa", "aa", "a" };
		int k2 = 1;
		System.out.println("Kth distinct string: " + kthDistinctStreams(arr2, k2)); // Output: "aaa"

		String[] arr3 = { "a", "b", "a" };
		int k3 = 3;
		System.out.println("Kth distinct string: " + kthDistinctStreams(arr3, k3)); // Output: ""

	}

	// Use iterative and Hash Table
	private static String kthDistinctMap(String[] arr, int k) {
		Map<String, Integer> freqMap = new LinkedHashMap<>();

		// Count frequency of each string
		for (String str : arr) {
			freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
		}

		// Find the kth distinct string
		int count = 0;
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() == 1) {
				count++;
				if (count == k) {
					return entry.getKey();
				}
			}
		}

		return "";
	}

	private static String kthDistinctStreams(String[] arr, int k) {
		Map<String, Long> freq = Arrays.stream(arr)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));

		return freq.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.skip(k - 1)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse("");
	}
}