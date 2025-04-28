package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem 1499 - Max Value of Equation
 * <p>
 * Description:
 * You are given an array of points(x, y) where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k.
 * You want to find the maximum value of yi + yj + |xi - xj| where |xi - xj| <= k and 0 <= i < j < points.length.
 * Return the maximum value of yi + yj + |xi - xj|. If there are no valid i and j return 0.
 * <p>
 * Link: https://leetcode.com/problems/max-value-of-equation/
 */

public class MaxValueOfEquation {

	public static void main(String[] args) {
		// Example usage
		int[][] points = {{1, 3}, {2, 0}, {3, 10}, {4, 5}};
		int k = 2;
		int result = findMaxValueOfEquation(points, k);
		System.out.println("Maximum value of equation: " + result); // Output: 10
	}

	private static int findMaxValueOfEquation(int[][] points, int k) {
		Deque<int[]> deque = new ArrayDeque<>();
		int res = Integer.MIN_VALUE;

		for (int[] point : points) {
			// point[0] is xi, point[1] is yi
			int x = point[0], y = point[1];

			// Remove points too far away
			while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
				// Remove points from the front of the deque that are too far away
				deque.pollFirst();
			}

			// Update res with best candidate
			if (!deque.isEmpty()) {
				// The best candidate is the first element in the deque
				res = Math.max(res, deque.peekFirst()[1] + x + y);
			}

			// Maintain decreasing order in deque (max yi-xi first)
			while (!deque.isEmpty() && deque.peekLast()[1] <= y - x) {
				// Remove elements that are not better candidates
				deque.pollLast();
			}

			// Add the current point to the deque
			deque.offerLast(new int[]{x, y - x});
		}

		// Return the maximum value found
		return res;
	}
}