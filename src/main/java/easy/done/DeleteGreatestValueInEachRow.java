package easy.done;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 2500 - Delete Greatest Value in Each Row
 * Topics: Array, Sorting, Heap
 * Time Complexity: O(m * n log n) - where m is the number of rows and n is the number of columns in the grid.
 * Space Complexity: O(1) - if we ignore the input storage, as we are sorting in place.
 * <p>
 * Description:
 * You are given an m x n matrix grid consisting of positive integers.
 * Perform the following operation until grid becomes empty:
 * - Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
 * - Add the maximum of deleted elements to the answer.
 * Return the answer after performing the operations described above.
 * <p>
 * Hint: Sort each row and then iterate over columns to find the maximum in each column.
 * Link: https://leetcode.com/problems/delete-greatest-value-in-each-row/
 */
public class DeleteGreatestValueInEachRow {
	public static void main(String[] args) {
		int[][] grid = {
			{1, 2, 4},
			{3, 3, 1}
		};
		// Output: 8
		// Explanation: The diagram above shows one way to delete values from each row to get a score of 8.
		System.out.println("Delete Greatest Value In Each Row: " + deleteGreatestValue(grid));

		grid = new int[][]{
			{10}
		};
		// Output: 10
		// Explanation: The diagram above shows one way to delete values from each row to get a score of 10.
		System.out.println("Delete Greatest Value In Each Row: " + deleteGreatestValue(grid));
	}

	public static int deleteGreatestValueHeap(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int answer = 0;

		// Step 1: Create a max-heap for each row
		PriorityQueue<Integer>[] heaps = new PriorityQueue[m];
		for (int i = 0; i < m; i++) {
			heaps[i] = new PriorityQueue<>(Comparator.reverseOrder());
			for (int val : grid[i]) {
				heaps[i].offer(val);
			}
		}

		// Step 2: Perform operations
		for (int op = 0; op < n; op++) {
			int maxRemoved = 0;
			for (int i = 0; i < m; i++) {
				int removed = heaps[i].poll(); // remove largest from row
				maxRemoved = Math.max(maxRemoved, removed);
			}
			answer += maxRemoved;
		}

		return answer;
	}

	private static int deleteGreatestValue(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		// Sort each row
		for (int r = 0; r < rows; r++) {
			Arrays.sort(grid[r]);
		}

		int score = 0;

		// Iterate over columns
		for (int c = 0; c < cols; c++) {
			int maxInCol = Integer.MIN_VALUE;
			for (int r = 0; r < rows; r++) {
				maxInCol = Math.max(maxInCol, grid[r][c]);
			}
			score += maxInCol;
		}

		return score;
	}
}