package easy.done;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 2335 - Minimum Amount of Time to Fill Cups
 * Topics: Array, Greedy, Heap
 * Time Complexity: O(n) - where n is the length of the input array.
 * Space Complexity: O(1) - only a constant amount of extra space is used.
 *
 * Description:
 * You have a water dispenser that can dispense cold, warm, and hot water. Every second, you can either fill up 2 cups with different types of water,
 * or fill up 1 cup of any type of water.
 * You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1], and amount[2] denote the number of cold, warm,
 * and hot water cups you need to fill respectively. Return the minimum number of seconds needed to fill up all the cups.
 *
 * Hint: Use a max heap to always fill the two types of water with the most remaining cups; or use a mathematical approach to determine the minimum time based on total cups and the maximum cups of a single type.
 * Link: https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
 */
public class MinimumAmountOfTimeToFillCups {
	public static void main(String[] args) {
		int[] amount = {1, 4, 2};
		// Output: 4
		// Explanation: The above diagram shows a way to fill the cups in 4 seconds.
		System.out.println("Minimum Amount of Time to Fill Cups: " + fillCupsMath(amount));

		amount = new int[]{5, 4, 4};
		// Output: 7
		// Explanation: One way to fill the cups is:
		// Second 1: Fill a cup of the second and third type. (0,3,3)
		// Second 2: Fill a cup of the first and second type. (4,2,3)
		// Second 3: Fill a cup of the first and third type. (3,2,2)
		// Second 4: Fill a cup of the first and second type. (2,1,2)
		// Second 5: Fill a cup of the first and third type. (1,1,1)
		// Second 6: Fill a cup of the first type. (0,1,1)
		// Second 7: Fill a cup of the second type. (0,0,1)
		System.out.println("Minimum Amount of Time to Fill Cups: " + fillCupsHeap(amount));

		amount = new int[]{5, 0, 0};
		// Output: 5
		// Explanation: The only way to fill the cups is to spend 5 seconds on the first type.
		System.out.println("Minimum Amount of Time to Fill Cups: " + fillCupsMath(amount));
	}

	private static int fillCupsMath(int[] amount) {
		int total = amount[0] + amount[1] + amount[2];
		int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
		return Math.max(max, (total + 1) / 2);
	}

	private static int fillCupsHeap(int[] amount) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int cups : amount) {
			if (cups > 0) maxHeap.add(cups);
		}

		int seconds = 0;
		while (!maxHeap.isEmpty()) {
			int first = maxHeap.poll();
			int second = maxHeap.isEmpty() ? 0 : maxHeap.poll();

			// Decrease the counts and re-add to the heap if there are remaining cups
			if (first > 1) maxHeap.add(first - 1);
			if (second > 1) maxHeap.add(second - 1);

			seconds++;
		}

		return seconds;
	}
}