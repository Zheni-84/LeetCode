package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode Problem 994 - Rotting Oranges
 * Time Complexity: O(rows * cols) - we visit each cell at most once
 * Space Complexity: O(rows * cols) - for the queue in the worst case when all oranges are rotten
 * Topics: Array, BFS, Matrix
 *
 * You are given an m x n grid where each cell can have one of three values:
 * - 0 representing an empty cell,
 * - 1 representing a fresh orange, or
 * - 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 *
 * Examples:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 *
 * Input: grid = [[0,2]]
 * Output: 0
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 *
 * Solution:
 * Use BFS to simulate the rotting process level by level (minute by minute).
 * Start with all initially rotten oranges in the queue and rot adjacent fresh oranges layer by layer.
 *
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(grid));
	}

	/**
	 * Calculates the minimum number of minutes until all fresh oranges rot.
	 * Uses BFS to process rotten oranges level by level, where each level represents one minute.
	 * <p>
	 * Algorithm:
	 * 1. Initialize the queue with all initial rotten oranges and count fresh oranges
	 * 2. Perform BFS by processing each level (minute) completely before moving to next
	 * 3. For each rotten orange, check all 4-directional neighbors and rot fresh oranges
	 * 4. Track the number of minutes elapsed and decrement fresh orange count
	 * 5. Return minutes if all fresh oranges rotted, otherwise return -1
	 *
	 * @param grid m x n grid where 0=empty, 1=fresh orange, 2=rotten orange
	 * @return minimum minutes required to rot all oranges, or -1 if impossible
	 */
	private static int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		Queue<int[]> queue = new ArrayDeque<>();
		int fresh = 0;

		// 1) Initialize
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 2) {
					queue.offer(new int[] { r, c });
				} else if (grid[r][c] == 1) {
					fresh++;
				}
			}
		}

		// No fresh oranges → 0 minutes
		if (fresh == 0)
			return 0;

		int minutes = 0;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		// 2) BFS by layers
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean rottedThisMinute = false;

			for (int i = 0; i < size; i++) {
				int[] cell = queue.poll();
				int r = cell[0], c = cell[1];

				for (int[] d : dirs) {
					int nr = r + d[0];
					int nc = c + d[1];

					if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
							&& grid[nr][nc] == 1) {

						grid[nr][nc] = 2;   // rot it
						fresh--;
						queue.offer(new int[] { nr, nc });
						rottedThisMinute = true;
					}
				}
			}

			if (rottedThisMinute)
				minutes++;
		}

		// 3) Final check
		return fresh == 0 ? minutes : -1;
	}
}