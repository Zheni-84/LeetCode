package easy.done;

import java.util.PriorityQueue;

/**
 * LeetCode Problem 2594 - Minimum Number Game
 * Topics: Array, Greedy, Heap
 * Time Complexity: O(n) - where n is the length of the input array.
 * Space Complexity: O(1) - only a constant amount of extra space is used.
 *
 * Description:
 * You are given a 0-indexed integer array nums. In one move, you can choose an index i such that 0 < i < nums.length and swap the values of nums[i] and nums[i - 1].
 * Return the minimum number of moves needed to move the minimum element to the front of the array.
 *
 * Hint: Find the index of the minimum element in the array; the number of moves required is equal to that index.
 * Link: https://leetcode.com/problems/minimum-number-game/
 */
public class MinimumNumberGame {
	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 4};
		// Output: 1
		// Explanation: The minimum number in the array is 1. It is already at the front of the array, so no moves are needed.
		System.out.println("Minimum Number Game: " + minimumMoves(nums));

		nums = new int[]{2, 2, 2, 1};
		// Output: 3
		// Explanation: The minimum number in the array is 1. We can move it to the front of the array in 3 moves:
		// - Move the element at index 3 to index 0. The array becomes [1, 2, 2, 2].
		System.out.println("Minimum Number Game: " + minimumMoves(nums));

		nums = new int[]{5, 5, 5};
		// Output: 0
		// Explanation: The minimum number in the array is 5. It is already at the front of the array, so no moves are needed.
		System.out.println("Minimum Number Game: " + minimumMoves(nums));
	}

	public int[] numberGame(int[] nums) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for(int num : nums){
			heap.offer(num);
		}

		int[] array = new int[nums.length];
		int i = 0;
		while(!heap.isEmpty()){
			int alice = heap.poll();
			if(!heap.isEmpty()){
				int bob = heap.poll();
				array[i++] = bob;
			}
			array[i++] = alice;
		}

		return array;
	}

	private static int minimumMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
				minIndex = i;
			}
		}

		return minIndex;
	}
}