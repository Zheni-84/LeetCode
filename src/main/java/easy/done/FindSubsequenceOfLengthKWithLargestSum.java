package easy.done;

import java.util.*;
import java.util.stream.IntStream;

/**
 * LeetCode Problem 2099 - Find Subsequence of Length K With the Largest Sum
 * Topics: Array, Sorting, Heap
 * Time Complexity: O(n log n) - due to sorting the indices.
 * Space Complexity: O(n) - for storing the indices and the result array.
 * <p>
 * Description:
 * Given an integer array nums and an integer k, return the subsequence of length k that has the largest sum.
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Hint: Sort the indices of the array based on the values in descending order, select the top k indices, sort them to maintain the original order, and then construct the result array.
 * Link: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 */
public class FindSubsequenceOfLengthKWithLargestSum {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 2, 6, 7, 1 };
		int k = 3;
		// Output: [5,6,7]
		// Explanation: The subsequence of length 3 with the largest sum is [5,6,7].
		System.out.println("Find Subsequence of Length K with Largest Sum: " + Arrays.toString(maxSubsequence(nums, k)));

		nums = new int[] { 2, 1, 3, 3 };
		k = 2;
		// Output: [3,3]
		// Explanation: The subsequence of length 2 with the largest sum is [3,3].
		System.out.println("Find Subsequence of Length K with Largest Sum: " + Arrays.toString(maxSubsequenceHeap(nums, k)));

		nums = new int[] { -1, -2, 3, 4 };
		k = 3;
		// Output: [-1,3,4]
		// Explanation: The subsequence of length 3 with the largest sum is [-1,3,4].
		System.out.println("Find Subsequence of Length K with Largest Sum: " + Arrays.toString(maxSubsequenceStream(nums, k)));
	}

	// Stream-based approach
	// Time Complexity: O(n log n) - due to sorting the indices.
	// Space Complexity: O(n) - for storing the indices and the result array.
	// This approach uses Java Streams to achieve the same result in a more concise manner.
	// It sorts the indices based on the values in descending order, selects the top k indices,
	// sorts them to maintain the original order, and then constructs the result array.
	private static int[] maxSubsequenceStream(int[] nums, int k) {
		return IntStream.range(0, nums.length)
				.boxed()
				.sorted((a, b) -> Integer.compare(nums[b], nums[a])) // sort by value desc
				.limit(k)
				.sorted() // restore original index order
				.mapToInt(i -> nums[i])
				.toArray();
	}

	// Stream-based approach using Map.Entry
	// Time Complexity: O(n log n) - due to sorting the indices.
	// Space Complexity: O(n) - for storing the indices and the result array.
	// This approach uses Java Streams to achieve the same result in a more concise manner.
	// It sorts the indices based on the values in descending order, selects the top k indices,
	// sorts them to maintain the original order, and then constructs the result array.
	private static int[] maxSubsequenceStreamEntry(int[] nums, int k) {
		return IntStream.range(0, nums.length)
				.mapToObj(i -> Map.entry(i, nums[i])) // (index, value)
				.sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed()) // sort by value desc
				.limit(k) // keep top k
				.sorted(Comparator.comparingInt(Map.Entry::getKey)) // sort by index asc
				.mapToInt(Map.Entry::getValue) // extract values
				.toArray();
	}

	// Time Complexity: O(n log n) - due to sorting the indices.
	// Space Complexity: O(n) - for storing the indices and the result array.
	// This approach sorts the indices of the array based on the values in descending order,
	// selects the top k indices, sorts them to maintain the original order, and then constructs
	// the result array.
	private static int[] maxSubsequence(int[] nums, int k) {
		int n = nums.length;
		Integer[] sortedIndices = new Integer[n];
		// Initialize indices
		for (int i = 0; i < n; i++) {
			sortedIndices[i] = i;
		}

		// Sort indices based on the values in nums in descending order
		Arrays.sort(sortedIndices, (a, b) -> Integer.compare(nums[b], nums[a]));

		// Select the top k indices
		Integer[] topKIndices = Arrays.copyOfRange(sortedIndices, 0, k);

		// Sort the selected indices to maintain the original order
		Arrays.sort(topKIndices);

		// Build the result array
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = nums[topKIndices[i]];
		}

		return result;
	}

	// Alternative approach using a min-heap (priority queue)
	// Time Complexity: O(n log k) - where n is the length of the input array.
	// Space Complexity: O(k) - for the heap and the result array.
	// This approach maintains a min-heap of size k to keep track of the top k elements,
	// then sorts them by their original indices to maintain the subsequence order.
	private static int[] maxSubsequenceHeap(int[] nums, int k) {
		// Min heap ordered by value
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		//Keep top k elements
		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(new int[] { nums[i], i });
			if (minHeap.size() > k) {
				// remove smallest element
				minHeap.poll();
			}
		}

		// extract top k (value, index) pairs
		List<int[]> topK = new ArrayList<>(minHeap);

		//Sort by original index to preserve subsequence order
		topK.sort(Comparator.comparingInt(a -> a[1]));

		//Extract Values
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = topK.get(i)[0];
		}

		return result;
	}
}