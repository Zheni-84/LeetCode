package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 1464 - Maximum Product of Two Elements in an Array
 * Topics: Array, Sorting, Heap
 * Time Complexity: O(n) - where n is the length of the input array.
 * Space Complexity: O(1) - only a constant amount of extra space is used.
 * <p>
 * Description:
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i] - 1) * (nums[j] - 1).
 * <p>
 * Hint: Find the two largest numbers in the array and calculate the product; or sort the array and take the last two elements;
 * or use a max heap to efficiently retrieve the two largest elements.
 * Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */
public class MaximumProductOfTwoElementsInArray {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 2 };
		// Output: 12
		// If you choose the indices i = 1 and j = 2 (0-indexed), you will get the maximum value, which is (4 - 1) * (5 - 1) = 3 * 4 = 12
		System.out.println("Maximum Product of Two Elements in an Array: " + maxProduct(nums));

		nums = new int[] { 1, 5, 4, 5 };
		// Output: 16
		// Explanation: Choosing the indices i = 1 and j = 3 (0-indexed) gives the maximum value of (5 - 1) * (5 - 1) = 16.
		System.out.println("Maximum Product of Two Elements in an Array: " + maxProductHeap(nums));

		nums = new int[] { 3, 7 };
		// Output: 12
		// Explanation: Choosing the indices i = 0 and j = 1 (0-indexed) gives the maximum value of (3 - 1) * (7 - 1) = 12.
		System.out.println("Maximum Product of Two Elements in an Array: " + maxProductStream(nums));
	}

	private static int maxProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int num : nums) {
			if (num > max1) {
				max2 = max1;
				max1 = num;
			} else if (num > max2) {
				max2 = num;
			}
		}

		return (max1 - 1) * (max2 - 1);
	}

	// Alternative solution using a max heap
	// This approach has a higher time complexity of O(n log n) due to heap operations.
	// Time Complexity: O(n log n)
	// Space Complexity: O(n) for the heap
	private static int maxProductHeap(int[] nums) {
		// Max heap (largest element first)
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		// Add all elements to the heap
		for (int num : nums) {
			maxHeap.offer(num);
		}

		// Extract the two largest elements
		int first = maxHeap.poll();
		int second = maxHeap.poll();

		return (first - 1) * (second - 1);
	}

	// More optimal heap solution using a min-heap to keep track only of the two largest numbers
	// Time Complexity: O(n)
	// Space Complexity: O(1) since the heap size is limited to 2
	private static int maxProductHeap2(int[] nums) {
		// Min-heap that keeps the 2 largest numbers
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > 2)
				// remove smallest, keep only 2 largest
				minHeap.poll();
		}

		// Extract the two largest left
		int max1 = minHeap.poll();
		int max2 = minHeap.poll();

		return (max1 - 1) * (max2 - 1);
	}

	// Stream-based solution
	// This approach is less efficient due to sorting but is concise and leverages Java Streams.
	// Time Complexity: O(n log n) due to sorting
	// Space Complexity: O(n) for the boxed stream
	private static int maxProductStream(int[] nums) {
		return Arrays.stream(nums)
				.boxed()
				.sorted((a, b) -> b - a)   // sort descending
				.limit(2)                  // take top 2
				.mapToInt(x -> x - 1)      // subtract 1
				.reduce(1, (a, b) -> a * b); // multiply
	}
}