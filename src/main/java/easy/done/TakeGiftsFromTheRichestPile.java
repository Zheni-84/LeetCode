package easy.done;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 2558 - Take Gifts From the Richest Pile
 * Topics: Array, Greedy, Heap
 * Time Complexity: O(k log n) - where n is the number of piles and k is the number of operations.
 * Space Complexity: O(n) - for storing the max-heap.
 *
 * Description:
 * You are given an integer array gifts denoting the number of gifts in each pile. Every second, you can perform the following operation:
 * - Choose any pile of gifts (i.e., gifts[i] where 0 <= i < gifts.length) and let x = gifts[i].
 * - Reduce the number of gifts in the pile to the floor of the square root of the original number of gifts in the pile.
 * - Return the number of gifts remaining after k seconds.
 *
 * Hint: Use a max-heap to always take from the pile with the most gifts, as this will minimize the total remaining gifts after k operations.
 * Link: https://leetcode.com/problems/take-gifts-from-the-richest-pile/
 */
public class TakeGiftsFromTheRichestPile {
	public static void main(String[] args) {
		int[] gifts = {25, 64, 9, 4, 100};
		int k = 4;
		// Output: 29
		// Explanation: The following is a possible scenario:
		// - In the first second, take from pile 4 (100). Now gifts = [25,64,9,4,100].
		// - In the second, take from pile 1 (64). Now gifts = [25,8,9,4,10].
		// - In the third second, take from pile 0 (25). Now gifts = [5,8,9,4,10].
		// - In the fourth second, take again from pile 4 (10) floor(sqrt(10)) = 3. Now gifts = [5,8,9,4,3].
		// The total number of gifts remaining after 4 seconds is 5 + 8 + 9 + 4 + 3 = 29.
		System.out.println("Take Gifts From the Richest Pile: " + pickGifts(gifts, k));

		gifts = new int[]{1,1,1,1};
		k = 4;
		// Output: 4
		// Explanation: Regardless of which pile you choose in each operation,
		// you have to reduce each pile to 1. Thus, the total number of gifts remaining is 1 + 1 + 1 + 1 = 4.
		System.out.println("Take Gifts From the Richest Pile: " + pickGifts(gifts, k));
	}

	private static long pickGifts(int[] gifts, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int pile : gifts){
			maxHeap.offer(pile);
		}

		while(!maxHeap.isEmpty() && k > 0){
			int pile = maxHeap.poll();
			int left = (int)Math.sqrt(pile);
			maxHeap.offer(left);
			k--;
		}

		int result = 0;
		while(!maxHeap.isEmpty()){
			result += maxHeap.poll();
		}

		return result;
	}
}