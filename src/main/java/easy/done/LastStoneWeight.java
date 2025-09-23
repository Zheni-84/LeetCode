package easy.done;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 1046 - Last Stone Weight
 * Topics: Array, Heap, Greedy
 * Time Complexity: O(n log n) - where n is the number of stones.
 * Space Complexity: O(n), for the heap.
 *
 * Description:
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 *
 * Hint: Use a max heap (priority queue) to efficiently retrieve and remove the two heaviest stones.
 * Link: https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		// Output: 1
		// Explanation:
		// We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
		// we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
		// we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
		// we combine 1 and 1 to get 0 so the array converts to [1] then that's the
		// value of the last stone.
		System.out.println("Last Stone Weight: " + lastStoneWeight(stones));

		stones = new int[] { 3, 7, 2 };
		// Output: 2
		// Explanation:
		// We combine 7 and 3 to get 4 so the array converts to [4,2] then,
		// we combine 4 and 2 to get 2 so the array converts to [2] then that's the
		// value of the last stone.
		System.out.println("Last Stone Weight: " + lastStoneWeight(stones));
	}

	private static int lastStoneWeight(int[] stones) {
		// Create a max heap and fill using streams
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		Arrays.stream(stones).forEach(heap::offer);

		//Smash stones until at most 1 remains
		while(heap.size() > 1){
			int first = heap.remove(); // largest
			int second = heap.remove(); // second largest

			if(first != second){
				heap.offer(first - second); // add back difference
			}
		}

		// if empty return 0, otherwise remove and return the last stone
		return heap.isEmpty() ? 0 : heap.remove();
	}
}