package easy.done;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 2357 - Make Array Zero by Subtracting Equal Amounts
 * Topics: Array, Hash Table, Sorting
 * Time Complexity: O(n) - where n is the length of the input array.
 * Space Complexity: O(n) - for storing unique positive numbers.
 *
 * Description:
 * You are given a non-negative integer array nums. In one operation, you must:
 * - Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
 * - Subtract x from every positive element in nums.
 * Return the minimum number of operations to make every element in nums equal to 0.
 *
 * Hint: The minimum number of operations required to make all elements zero is equal to the count of distinct positive integers in the array.
 * Link: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 */
public class MakeArrayZeroBySubtractingEqualAmounts {
	public static void main(String[] args) {
		int[] nums = {1, 5, 0, 3, 5};
		// Output: 3
		// Explanation: The array can be made empty after the following operations:
		// - Choose x = 1. The resulting array is [4, 0, 2, 4].
		// - Choose x = 2. The resulting array is [2, 0, 2].
		// - Choose x = 2. The resulting array is [0, 0].
		System.out.println("Make Array Zero By Subtracting Equal Amounts: " + minimumOperations(nums));

		nums = new int[]{0};
		// Output: 0
		// Explanation: The array is already empty.
		System.out.println("Make Array Zero By Subtracting Equal Amounts: " + minimumOperations(nums));

		nums = new int[]{1, 1, 1};
		// Output: 1
		// Explanation: The array can be made empty after the following operation:
		// - Choose x = 1. The resulting array is [0, 0, 0].
		System.out.println("Make Array Zero By Subtracting Equal Amounts: " + minimumOperations(nums));
	}

	private static int minimumOperations(int[] nums) {
		return (int) Arrays.stream(nums).filter(num -> num > 0).distinct().count();
	}

	private static int minimumOperationsHeap(int[] nums) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		//Add only positive numbers
		for(int num : nums){
			if(num > 0) heap.offer(num);
		}

		int operations = 0;
		int offset = 0;

		while(!heap.isEmpty()){
			int curr = heap.poll();
			// SKip if already reduced to zero after previous subtractions
			if(curr <= offset) continue;

			// New operation
			operations++;
			// Update how much ew subtracted so far
			offset = curr;
		}

		return operations;
	}

}