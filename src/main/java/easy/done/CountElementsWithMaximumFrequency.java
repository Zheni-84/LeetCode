package easy.done;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * LeetCode Problem 2428: Count Elements With Maximum Frequency
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Topics: Array, Hash Table, Counting
 *
 * Given an array of integers nums, return the count of elements that have the maximum frequency in the array.
 *
 * Example:
 * Input: nums = [1,3,2,2,3,1,3,3]
 * Output: 4
 * Explanation: The maximum frequency is 4 (number 3 appears 4 times). Thus, the count of elements with maximum frequency is 4.
 *
 * Hint: Use a frequency map to count occurrences and then determine the maximum frequency and its count.
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/
 */
public class CountElementsWithMaximumFrequency {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 2, 2, 3, 1, 3, 3 };
		int[] nums2 = { 1, 2, 3, 4, 5, 6 };

		System.out.println("Count of elements with maximum frequency (Approach 1): " + maxFrequencyElements(nums1)); // Output: 4
		System.out.println("Count of elements with maximum frequency (Approach 1): " + maxFrequencyElementsArray(nums2)); // Output: 6
	}

	// Approach 1: Using freq array
	// Time Complexity: O(n)
	// Space Complexity: O(m) where m is the range of input values
	private static int maxFrequencyElementsArray(int[] nums) {
		int maxVal = Arrays.stream(nums).max().orElse(0);
		int[] freq = new int[maxVal + 1];
		for (int num : nums) {
			freq[num]++;
		}
		int maxFreq = Arrays.stream(freq).max().orElse(0);
		int total = 0;
		for (int f : freq) {
			if (f == maxFreq) {
				total += f;
			}
		}
		return total;
	}

	// Alternative approach using Streams
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static int maxFrequencyElements(int[] nums) {
		Map<Integer, Integer> freq = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.toMap(x -> x, x -> 1, Integer::sum));

		int maxNum = Collections.max(freq.values());

		return freq.values().stream()
				.filter(num -> num == maxNum)
				.mapToInt(Integer::intValue)
				.sum();
	}
}